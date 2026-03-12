package com.main;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    public void payment() {
        System.out.println("Doing Payment");
    }

    @PostConstruct
    public void beforeInit() {
        System.out.println("Before Payment");
    }

    @PreDestroy
    public void afterInit() {
        System.out.println("After Payment");
    }
}
