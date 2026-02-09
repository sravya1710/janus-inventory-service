package com.janus.inventory.controller;

import com.janus.inventory.model.Product;
import com.janus.inventory.model.Warehouse;
import com.janus.inventory.service.ProductService;
import com.janus.inventory.service.WarehouseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping(path="api/warehouse")
public class WarehouseController {

    private final WarehouseService warehouseService;

    @Autowired
    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping
    public List<Warehouse> getWarehouse(){
        return warehouseService.getWarehouse();
    }

    @PostMapping
    public ResponseEntity<Warehouse> addnewWarehouse(
            @Valid @RequestBody Warehouse warehouse
    ) {
        Warehouse saved = warehouseService.addWarehouse(warehouse);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }


}
