package com.booleanuk.api.products.model;

import java.util.ArrayList;

public class ProductRepository {
    private ArrayList<Product> products;

    public ProductRepository(){
        this.products = new ArrayList<>();
        this.products.add(new Product("product1", "category1", 100));
        this.products.add(new Product("product2", "category2", 40));
        this.products.add(new Product("product3", "category3", 90));

    }

    public ArrayList<Product> getAll(){
        return this.products;
    }

    public Product getOne(int id){
        for (Product product: this.products){
            if (product.getId() == id){
                return product;
            }
        } return null;
    }

    public void addProduct(Product product){
        products.add(product);
    }

}


