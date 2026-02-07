package com.janus.inventory.model;

public enum TransactionType {
    RESTOCK,        // Supplier delivered stock
    SALE,           // Customer order consumed stock
    RETURN,         // Customer returned item
    DAMAGE        // Stock damaged / expired
}
