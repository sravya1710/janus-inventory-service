package com.janus.inventory.service;

import com.janus.inventory.model.Warehouse;
import com.janus.inventory.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {

    private final WarehouseRepository warehouseRepo ;

    @Autowired
    public WarehouseService(WarehouseRepository warehouseRepo) {
        this.warehouseRepo = warehouseRepo;
    }


    public List<Warehouse> getWarehouse(){
        return warehouseRepo.findAll();
    }


    public Warehouse addWarehouse(Warehouse warehouse ){
            Optional<Warehouse> warehouseOptional = warehouseRepo.findWarehouseByCode(warehouse.getCode());
            if(warehouseOptional.isPresent()){
                return warehouseOptional.get();            }
            warehouseRepo.save(warehouse);
        return warehouse;
    }
}
