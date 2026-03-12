package com.main;

import com.main.Impl.EmailNotificationService;
import com.main.Impl.SmsNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class A02DependencyInjectionApplication implements CommandLineRunner{

    @Autowired
    SmsNotificationService smsNotificationService;

    @Autowired
    EmailNotificationService emailNotificationService;


    @Override
    public void run(String... args) throws Exception {
        smsNotificationService.send("I am here from SMS");
        emailNotificationService.send("I am here from Email");
    }

    public static void main(String[] args) {
        SpringApplication.run(A02DependencyInjectionApplication.class, args);
    }

}
