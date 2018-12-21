/**
 * Copyright 2019 Mahabir Singh. All rights reserved.
 */

package singh.mahabir;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import lombok.extern.slf4j.Slf4j;

/**
 * Implements main entry point for the Micro Service.
 *
 * @author Mahabir Singh
 */

@SpringBootApplication
@Slf4j
public class AllInOneApplication implements ApplicationListener<ApplicationReadyEvent> {
    public static void main(String[] args) {
        SpringApplication.run(AllInOneApplication.class, args);
    }

    /**
     * Handle an application event.
     * 
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationEvent) {
        log.info("onApplicationEvent : ApplicationReadyEvent Is Triggered");
        log.info("Application started with command-line arguments: {}", Arrays.toString(applicationEvent.getArgs()));
    }
}
