package com.janus.inventory.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="inventory_transaction",
        indexes={
                @Index(name="id_product_warehouse",
                        columnList ="product_id,warehouse_id")
        })

public class InventoryTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private TransactionType transactionType;

    @NotNull
    @Column(nullable = false)
    private Integer quantity;

    @Size(max = 100)
    private String referenceId;

    @Size(max = 255)
    private String remarks;

    @NotBlank
    @Column(nullable = false)
    private String createdBy;

}

