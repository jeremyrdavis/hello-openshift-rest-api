package com.redhat.greetings;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingRepository implements PanacheRepository<Greeting> {

    GreetingDTO persist(GreetingDTO greetingDTO) {
        Greeting greeting = new Greeting(greetingDTO.text(), greetingDTO.author(), greetingDTO.sourceSystem(), greetingDTO.createdAt());
        greeting.persist();
        return new GreetingDTO(greeting.id, greeting.text, greeting.author, greeting.sourceSystem, greeting.createdAt);
    }
}
