package com.janus.inventory.repository;

import com.janus.inventory.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse,Long>{
}
