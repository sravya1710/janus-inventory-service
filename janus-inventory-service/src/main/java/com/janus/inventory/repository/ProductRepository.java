package com.janus.inventory.repository;

import com.janus.inventory.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository  extends JpaRepository<Product, Long> {

    @Query("SELECT s FROM Product s WHERE s.sku=?1")
    Optional<Product> findProductBySku(String sku);
}
