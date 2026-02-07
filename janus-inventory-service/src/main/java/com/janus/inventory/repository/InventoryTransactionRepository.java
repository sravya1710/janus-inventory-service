package com.janus.inventory.repository;

import com.janus.inventory.model.InventoryTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryTransactionRepository extends JpaRepository<InventoryTransaction,Long> {
}
