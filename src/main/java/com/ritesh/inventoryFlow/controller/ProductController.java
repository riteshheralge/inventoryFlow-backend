package com.ritesh.inventoryFlow.controller;

import com.ritesh.inventoryFlow.entity.Product;
import com.ritesh.inventoryFlow.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")

public class ProductController {

    @Autowired
    private ProductService service;

    // Add Product API
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    // Get All Products API
    @GetMapping
    public List<Product> getProducts() {
        return service.getAllProducts();
    }

    // Get Product By ID API
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
        return service.getProductById(id);
    }

    // Update Product API
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable String id,
                                 @RequestBody Product product) {

        return service.updateProduct(id, product);
    }

    // Delete Product API
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable String id) {

        return service.deleteProduct(id);
    }
}