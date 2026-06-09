package com.ritesh.inventoryFlow.service;
import com.ritesh.inventoryFlow.exception.ProductNotFoundException;
import com.ritesh.inventoryFlow.entity.Product;
import com.ritesh.inventoryFlow.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ritesh.inventoryFlow.exception.ProductNotFoundException;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    // Add Product
    public Product addProduct(Product product) {
        return repository.save(product);
    }

    // Get All Products
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    // Get Product By ID
    public Product getProductById(String id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException("Product not found with ID: " + id));
    }

    // Update Product
    public Product updateProduct(String id, Product updatedProduct) {

        Product existingProduct = repository.findById(id).orElse(null);

        if (existingProduct != null) {

            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setQuantity(updatedProduct.getQuantity());

            return repository.save(existingProduct);
        }

        return null;
    }

    // Delete Product
    public String deleteProduct(String id) {

        repository.deleteById(id);

        return "Product deleted";
    }
}