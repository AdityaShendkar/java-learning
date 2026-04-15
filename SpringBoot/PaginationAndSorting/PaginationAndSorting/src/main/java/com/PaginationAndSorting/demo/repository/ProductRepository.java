package com.PaginationAndSorting.demo.repository;

import com.PaginationAndSorting.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
