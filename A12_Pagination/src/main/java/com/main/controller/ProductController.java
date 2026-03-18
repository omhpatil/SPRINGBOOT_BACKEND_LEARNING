package com.main.controller;

import com.main.entity.ProductEntity;
import com.main.repository.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final int PAGE_SIZE = 5;

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/sortByOrder")
    public List<ProductEntity> getAllProductsByOrderByPrice() {
        return productRepository.findByOrderByPrice();
    }

    @GetMapping("/sortByQuantity")
    public List<ProductEntity> getAllProductsByOrderByQuantity() {
        return productRepository.findByOrderByQuantity();
    }

    @GetMapping("/sortBySku")
    public List<ProductEntity> getAllProductsByOrderBySku() {
        return productRepository.findAllByOrderBySku();
    }

//    // for dynamic sorting
//    @GetMapping
//    public List<ProductEntity> getAllProducts(
//            @RequestParam(defaultValue = "id") String sortBy
//    ) {
//        return productRepository.findAll(Sort.by(Sort.Direction.ASC, sortBy, "price", "quantity"));
//        // first it will sort based on the parameter, if they are same then it will check price and then quanaity
//    }

    @GetMapping
    public List<ProductEntity> getAllProducts(
            @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "0") Integer pageNumber) {

        return productRepository.findByTitleContainingIgnoreCase(
                title,
                PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(sortBy))
        );

//
//        return productRepository.findBy(Sort.by(Sort.Direction.DESC, sortBy, "price"));
//        return productRepository.findBy(Sort.by(
//                Sort.Order.desc(sortBy),
//                Sort.Order.desc("title")
//        ));


//        Pageable pageable = PageRequest.of(
//                pageNumber,
//                PAGE_SIZE,
//                Sort.by(sortBy));
//
//        return productRepository.findAll(pageable).getContent();


    }

}
