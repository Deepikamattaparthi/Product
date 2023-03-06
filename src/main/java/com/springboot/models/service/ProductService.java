package com.springboot.models.service;

import com.springboot.models.Repository.ProductRepository;
import com.springboot.models.dto.ProductDto;
import com.springboot.models.entity.Product;
import com.springboot.models.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            throw new IllegalArgumentException("Invalid product id: " + id);
        }
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Update a product
    public Product updateProduct(Long id, Product product) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            return productRepository.save(existingProduct);
        } else {
            return null;
        }
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
