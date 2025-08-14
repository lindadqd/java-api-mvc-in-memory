package com.booleanuk.api.products.controller;

import com.booleanuk.api.products.model.Product;
import com.booleanuk.api.products.model.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


@RestController
    @RequestMapping("products")
    public class ProductController {
    private ProductRepository productRepository;

    public ProductController() {
        this.productRepository = new ProductRepository();
    }

    @GetMapping
    public ArrayList<Product> getAll() {
        return this.productRepository.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product newProduct){
        this.productRepository.addProduct(newProduct);
        return newProduct;
    }

    @GetMapping("/{id}")
    public Product getOne(@PathVariable int id) {
        Product product = productRepository.getOne(id);
        if (product == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Did not find this product");
        }
        return product;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Product update(@PathVariable int id, @RequestBody Product product ) {
        List<Product> products = productRepository.getAll();
        if(id < products.size()) {
            products.get(id).setName(product.getName());
            products.get(id).setCategory(product.getCategory());
            products.get(id).setPrice(product.getPrice());
            return products.get(id);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Product delete(@PathVariable int id){
        List<Product> products = productRepository.getAll();
        if (id < products.size()) {
            return products.remove(id);
        }
        return null;
    }

}
