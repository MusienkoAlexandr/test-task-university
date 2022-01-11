package com.musiienko.university;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestTaskUniversityApplication implements CommandLineRunner {


    public static void main(String... args) {
        SpringApplication.run(TestTaskUniversityApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Will the Real Slim Shady, please, stand up?");
    }
}