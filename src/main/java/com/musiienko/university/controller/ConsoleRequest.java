package com.musiienko.university.controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * Annotation for mapping service-layer methods with the requests
 * (see {@link DispatcherController} for more details).
 * </p>
 * <p>
 * <b>ATTENTION:</b> One should make sure, that he uses unique request string patterns
 * as values for annotations, otherwise expected behavior is not guarantied.
 * </p>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ConsoleRequest {
    String value() default "";
}
