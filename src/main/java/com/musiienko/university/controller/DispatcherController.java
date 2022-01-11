package com.musiienko.university.controller;

import com.musiienko.university.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**<p>
 * Controller, that matches requests, forwarded from command line,
 * matches to the correct request pattern and invokes the corresponding
 * service method.
 * </p>
 * <p>
 * Uses an implemented Spring-like approach:
 * </p>
 * <p>
 * Methods in service-layer are annotated with <b>@ConsoleRequest</b> with value
 * representing request pattern.
 * </p>
 * <p>
 * Controller iterates all the services, checks their method for annotation,
 * checks the regex-match for pattern and current request, and if it matches,
 * invokes the service-method.
 * </p>
 * <p>
 * Another approach would be in using Command pattern and, probably a hashmap
 * with a String key (request pattern).
 * </p>
 */
@Component
public class DispatcherController {

    private final List<GenericService> services = new ArrayList<>();

    public DispatcherController(@Autowired GenericService... services) {
        this.services.addAll(Arrays.asList(services));
    }

    public String process(String request) {
        Optional<String> result;
        for (GenericService service : services) {
            result = processService(service, request);
            if (result.isPresent()) return result.get();
        }
        return "Something went wrong...";
    }

    private Optional<String> processService(GenericService service, String request) {
        String value;
        Pattern pattern;
        Matcher matcher;
        String argument;
        for (Method method : service.getClass().getInterfaces()[0].getDeclaredMethods()) {
            if (method.isAnnotationPresent(ConsoleRequest.class)) {
                value = method.getAnnotation(ConsoleRequest.class).value();
                value = value.replaceAll("\\{.*}", "(.*)");
                pattern = Pattern.compile(value);
                matcher = pattern.matcher(request);
                if (matcher.matches()) {
                    argument = matcher.group(1);
                    try {
                        return Optional.of((String) method.invoke(service, argument));
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return Optional.empty();
    }
}
