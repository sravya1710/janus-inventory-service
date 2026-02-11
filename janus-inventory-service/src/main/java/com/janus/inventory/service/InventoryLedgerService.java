package com.janus.inventory.service;

import com.janus.inventory.model.InventoryTransaction;
import com.janus.inventory.model.Product;
import com.janus.inventory.repository.InventoryTransactionRepository;
import com.janus.inventory.repository.ProductRepository;
import com.janus.inventory.repository.WarehouseRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class InventoryLedgerService {
    private final ProductRepository productRepository;
    private final WarehouseRepository warehouseRepository;
    private final InventoryTransactionRepository inventoryTransactionRepository ;


    public InventoryLedgerService(ProductRepository productRepository,
                                  WarehouseRepository warehouseRepository ,
                                  InventoryTransactionRepository inventoryTransactionRepository) {
        this.productRepository = productRepository;
        this.warehouseRepository = warehouseRepository;
        this.inventoryTransactionRepository = inventoryTransactionRepository;

    }

    @Transactional
    public void validateTransaction(InventoryTransaction inventoryTransaction){
        Product product = productRepository.findById(request.getProductId());




















































































































    }
}
