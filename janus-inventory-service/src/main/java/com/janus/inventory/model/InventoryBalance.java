package com.janus.inventory.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
@Table(name="inventory_balance",
    indexes={
        @Index(name="id_product_warehouse",
        columnList ="product_id,warehouse_id")
    })

public class InventoryBalance {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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
    private Long onhand_qt;

    @NotNull
    @Column(nullable=false)
    private Long reserved_qt=0L;

    @NotNull
    private Long available_qt;





}
