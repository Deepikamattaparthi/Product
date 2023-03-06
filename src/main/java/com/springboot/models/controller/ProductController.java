package com.springboot.models.controller;

import com.springboot.models.dto.ProductDto;
import com.springboot.models.entity.Product;
import com.springboot.models.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

        private final ProductService productService;

        @Autowired
        public ProductController(ProductService productService) {
                this.productService = productService;
        }

        @PostMapping
        public ResponseEntity<Product> createProduct(@RequestBody Product product) {
                Product createdProduct = productService.createProduct(product);
                return ResponseEntity.ok(createdProduct);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Product> getProductById(@PathVariable Long id) {
                Product product = productService.getProductById(id);
                return ResponseEntity.ok(product);
        }

        @GetMapping
        public ResponseEntity<List<Product>> getAllProducts() {
                List<Product> products = productService.getAllProducts();
                return ResponseEntity.ok(products);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long id,
                                                     @RequestBody Product product) {
                Product updatedProduct = productService.updateProduct(id, product);
                if (updatedProduct == null) {
                        return ResponseEntity.notFound().build();
                }
                return ResponseEntity.ok(updatedProduct);
        }

        @RequestMapping(method = RequestMethod.DELETE, value = "/products/{id}")
        public String removeAProduct(@PathVariable Long id) {
                try {
                        productService.deleteProduct(id);
                        return "Customer with id " + id + " is deleted successfully";
                } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println(e);
                        return "Exception in controller class";
                }
        }
}
