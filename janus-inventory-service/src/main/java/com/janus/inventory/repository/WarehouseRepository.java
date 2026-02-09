package com.janus.inventory.repository;

import com.janus.inventory.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface WarehouseRepository extends JpaRepository<Warehouse,Long>{

    @Query("SELECT s FROM Warehouse s WHERE s.code = ?1")
    Optional<Warehouse> findWarehouseByCode(String code);
}
