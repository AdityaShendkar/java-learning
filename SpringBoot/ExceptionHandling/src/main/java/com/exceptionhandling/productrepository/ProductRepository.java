package com.exceptionhandling.productrepository;

import com.exceptionhandling.productentity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    //using fields
    Optional<Product> findByName(String name);
    List<Product> findByPrice(Double price);

    //using combination of fields
    List<Product> findByNameAndPrice(String name, Double price);

    // Using operator
    List<Product> findByPriceGreaterThan(Double price);
    List<Product> findByNameContaining(String name);

}
