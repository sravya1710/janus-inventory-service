package com.janus.inventory.controller;


import com.janus.inventory.model.InventoryTransaction;
import com.janus.inventory.service.InventoryLedgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping(path="inventory")
public class InventoryTransactionController {
    private final InventoryLedgerService inventoryLedgerService;

    @Autowired
    public InventoryTransactionController(InventoryLedgerService inventoryLedgerService) {
        this.inventoryLedgerService = inventoryLedgerService;
    }

    @PostMapping("transaction")
    public void addNewTransaction (@RequestBody InventoryTransaction inventoryTransaction){

    }

}
