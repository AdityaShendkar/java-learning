package com.PaginationAndSorting.demo.service;

import com.PaginationAndSorting.demo.entity.Product;
import com.PaginationAndSorting.demo.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {

    @Autowired
    ProductRepository productrepository;

//    @PostConstruct
//    public void initDB() {
//        List<Product> products = IntStream.rangeClosed(1, 200)
//                .mapToObj(i -> new Product("product" + i, new Random().nextInt(100), new Random().nextInt(50000)))
//                .collect(Collectors.toList());
//        productrepository.saveAll(products);
//    }

    public List<Product> findAllProducts() {
        return productrepository.findAll();
    }

    public List<Product> findProductsWithSorting(String field){
        return productrepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    public List<Product> findProductsWithPagination(int offset, int pageSize){
        return productrepository.findAll(PageRequest.of(offset,pageSize)).getContent();
    }
}
