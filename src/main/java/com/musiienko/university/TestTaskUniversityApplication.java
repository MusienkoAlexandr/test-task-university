package com.musiienko.university;

import com.musiienko.university.controller.DispatcherController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

/**
 * <p>
 * Console endpoint of the application. Currently supports next console commands:
 * </p>
 * <ul>
 * <li><b><i>Who is head of department {department_name}</i></b></li>
 * <li><b><i>Show {department_name} statistics</i></b></li>
 * <li><b><i>Show the average salary for the department {department_name}</i></b></li>
 * <li><b><i>Show count of employee for {department_name}</i></b></li>
 * <li><b><i>Global search by {template}</i></b></li>
 * <li><b><i>exit</i></b> - shuts down the application.</li>
 * </ul>
 */
@SpringBootApplication
public class TestTaskUniversityApplication implements CommandLineRunner {

    DispatcherController controller;

    public TestTaskUniversityApplication(@Autowired DispatcherController controller) {
        this.controller = controller;
    }

    public static void main(String... args) {
        SpringApplication.run(TestTaskUniversityApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        String request = scanner.nextLine();
        while(!request.equals("exit")) {
            System.out.println(controller.process(request));
            request = scanner.nextLine();
        }

    }
}
