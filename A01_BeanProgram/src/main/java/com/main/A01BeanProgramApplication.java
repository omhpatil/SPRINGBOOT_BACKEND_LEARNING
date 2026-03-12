package com.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class A01BeanProgramApplication implements CommandLineRunner {

    @Autowired
    private PaymentService paymentService1;

    @Autowired
    private PaymentService paymentService2;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(paymentService1.hashCode());
        System.out.println(paymentService2.hashCode());

        paymentService1.payment();
        paymentService2.payment();
    }

    public static void main(String[] args) {
        SpringApplication.run(A01BeanProgramApplication.class, args);
//        PaymentService paymentService =  new PaymentService();         //without using springboot we need to create object by using the new keyword
    }


}
