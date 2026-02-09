package com.janus.inventory.controller;

import com.janus.inventory.model.Product;
import com.janus.inventory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping(path="api/product")
public class ProductController {

    private final ProductService prodService;

    @Autowired
    public ProductController(ProductService prodService) {
        this.prodService = prodService;
    }

    @GetMapping
    public List<Product> getProducts(){
        return prodService.getProducts();
    }

    @PostMapping
    public void addnewProduct(@RequestBody Product prod){
        prodService.addProducts(prod);
    }


}
