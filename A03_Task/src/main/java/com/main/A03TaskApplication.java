package com.main;

import com.main.baker.CakeBaker;
import com.main.frosting.Frosting;
import com.main.syrup.Syrup;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class A03TaskApplication implements CommandLineRunner {

    private final CakeBaker cakeBaker;

    public A03TaskApplication(CakeBaker cakeBaker) {
        this.cakeBaker = cakeBaker;
    }

    @Override
    public void run(String... args) throws Exception {
        cakeBaker.bakeCake();
    }

    public static void main(String[] args) {
        SpringApplication.run(A03TaskApplication.class, args);
    }
}
