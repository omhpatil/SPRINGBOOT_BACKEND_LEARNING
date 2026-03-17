package com.main;

import com.main.entity.ProductEntity;
import com.main.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class A10HibernateApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testRepository() {
        ProductEntity productEntity = ProductEntity.builder()
                .sku("nestle123")
                .title("Nestle Maggi")
                .price(BigDecimal.valueOf(123.45))
                .quantity(15)
                .build();

        ProductEntity productEntity1 = productRepository.save(productEntity);
        System.out.println(productEntity1);
    }

    @Test
    void getRepository1() {
        List<ProductEntity> entities = productRepository.findAll();
        System.out.println(entities);
    }

    @Test
    void getRepository2() {
        List<ProductEntity> entities = productRepository.findByTitle("parle biscuits");
        System.out.println(entities);
    }
}
