package com.ringodev.server.data.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

    private final UserRepository repository;

    UserCommandLineRunner(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {
        repository.findAll().forEach(System.out::println);
    }
}


