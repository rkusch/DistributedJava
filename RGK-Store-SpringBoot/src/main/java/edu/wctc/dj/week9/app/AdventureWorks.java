package edu.wctc.dj.week9.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "edu.wctc.dj.week9")
public class AdventureWorks {

    public static void main(String[] args) {
        SpringApplication.run(AdventureWorks.class, args);
    }

}