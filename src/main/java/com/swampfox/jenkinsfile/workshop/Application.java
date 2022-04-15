package com.swampfox.jenkinsfile.workshop;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public Application() {
    }

    public static void main(String[] args) {
        new Application().run(new SpringApplicationBuilder(Application.class).build());
    }
}
