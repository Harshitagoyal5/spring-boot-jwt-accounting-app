package com.alibou.security.project.entity.purchase;

import com.alibou.security.project.entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class PurchDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Product product;
    @Column(nullable = false)
    private Double price=0.0;
    @Column(nullable = false)
    private int Qty=1;
    private Double amt;
    @Column(nullable = false)
    private Long gen;
    private Long inv_id;
//    @ManyToOne
//    private InvoicePurch invoicePurch;
}
