package com.ritesh.inventoryFlow.repository;

import com.ritesh.inventoryFlow.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository
        extends MongoRepository<Product, String> {

}