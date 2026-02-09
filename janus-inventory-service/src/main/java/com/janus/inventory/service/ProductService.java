package com.janus.inventory.service;

import com.janus.inventory.model.Product;
import com.janus.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    private final ProductRepository prodRepo;


    @Autowired
    public ProductService(ProductRepository prodRepo) {
        this.prodRepo = prodRepo;
    }

    //get all products available
    public List<Product> getProducts(){
        return prodRepo.findAll();
    }


    public void addProducts(Product prod ){
        Optional<Product> productOptional = prodRepo.findProductBySku(prod.getSku());
        if(productOptional.isPresent()){
            throw new IllegalStateException("SKU is already taken");
        }
        prodRepo.save(prod);
    }


}
