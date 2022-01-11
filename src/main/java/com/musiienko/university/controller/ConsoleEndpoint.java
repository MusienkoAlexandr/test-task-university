package com.musiienko.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

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
@Profile("!test")
@Component
public class ConsoleEndpoint implements CommandLineRunner {

    DispatcherController controller;

    public ConsoleEndpoint(@Autowired DispatcherController controller) {
        this.controller = controller;
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
