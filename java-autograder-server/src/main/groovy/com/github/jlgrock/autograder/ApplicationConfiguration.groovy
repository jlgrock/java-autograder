package com.github.jlgrock.autograder
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
/**
 *
 */
// Normally you would add @EnableWebMvc for a Spring MVC app, but Spring Boot adds it automatically
// when it sees spring-webmvc on the classpath.
@Configuration // tags the class as a source of bean definitions for the application context.
@EnableAutoConfiguration // tells Spring Boot to start adding beans based on classpath settings and properties
@ComponentScan // tells Spring to look for other components in this package (and below)
class ApplicationConfiguration {
    private static Logger LOGGER = LoggerFactory.getLogger(ApplicationConfiguration.class);

    static void main(String[] args) throws Exception {
        LOGGER.info("Starting Spring Boot Application.");
        SpringApplication.run(ApplicationConfiguration.class, args);
    }
}
