package com.hdfc.Grocery.App.service;

import com.hdfc.Grocery.App.dao.ProductRepository;
import com.hdfc.Grocery.App.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long productId, Product updatedProduct) {
        Optional<Product> existingProductOptional = productRepository.findById(productId);

        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();
            // Update existingProduct fields with updatedProduct
            // For example: existingProduct.setProductName(updatedProduct.getProductName());
            return productRepository.save(existingProduct);
        } else {
            // Handle product not found
            return null;
        }
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}

