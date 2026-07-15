package com.exceptionhandling.productservice;

import com.exceptionhandling.productexception.DuplicateProductException;
import com.exceptionhandling.productexception.ProductNotFoundException;
import com.exceptionhandling.productrepository.ProductRepository;
import com.exceptionhandling.productentity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    // Create Product
    public Product createProduct(Product product) {

        if (productRepository.findByName(product.getName()).isPresent()){
            throw new DuplicateProductException("Product by the name "+ product.getName() + "is already available");
        }
        return productRepository.save(product);
    }

    // Get Product by ID
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("Product with id: "+id+" is not found"));
    }

    // Update Product
    public Product updateProduct(Long id, Product product) {

        Product existingProduct = getProduct(id);

        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());

        return productRepository.save(existingProduct);
    }

    // Delete Product
    public void deleteProduct(Long id) {

        Product product = getProduct(id);

        productRepository.delete(product);
    }
}
