package com.PaginationAndSorting.demo.controller;

import com.PaginationAndSorting.demo.dto.APIResponse;
import com.PaginationAndSorting.demo.entity.Product;
import com.PaginationAndSorting.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    private APIResponse<List<Product>> getProducts() {
        List<Product> allProducts = service.findAllProducts();
        return new APIResponse<>(allProducts.size(), allProducts);
    }
    @GetMapping("/{field}")
    private APIResponse<List<Product>> getProductsWithSort(@PathVariable String field){
        List<Product> allProducts =  service.findProductsWithSorting(field);
        return new APIResponse<>(allProducts.size(), allProducts);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    private APIResponse<List<Product>> getProductsWithPagination(@PathVariable int offset,@PathVariable int pageSize){
        List<Product> productsWithPagination = service.findProductsWithPagination(offset, pageSize);
        return new APIResponse<>(productsWithPagination.size(),productsWithPagination);
    }

}
