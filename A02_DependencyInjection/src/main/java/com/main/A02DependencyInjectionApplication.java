package com.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class A02DependencyInjectionApplication implements CommandLineRunner{

//    @Autowired                                                    // Field DI
    final NotificationService notificationService;      // Cannot change again tiw make it made it final here

    // Constructor DI
    public A02DependencyInjectionApplication(NotificationService notificationService){
        this.notificationService = notificationService;
    }

//    public A02DependencyInjectionApplication(@Qualifier("emailNotify") NotificationService notificationService){
//        this.notificationService = notificationService;
//    }

    @Override
    public void run(String... args) throws Exception {
        notificationService.send("Hello World");
//        this.notificationService = null;        // Cannot modify value because of final
    }

    public static void main(String[] args) {
        SpringApplication.run(A02DependencyInjectionApplication.class, args);
    }

}


// Field notificationService in com.main.A02DependencyInjectionApplication required a single bean, but 2 were found:
// So use @Primary annotation on atleast one bean - So here we used on the SmsNotificationClass and issue resolved
// There is one more alternative way to resolve it by using the @Qualifier("smsNotificationService") annotation
// In real Spring Boot projects, we inject interfaces, not implementations.