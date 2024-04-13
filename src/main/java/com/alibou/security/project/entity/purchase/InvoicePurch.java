package com.alibou.security.project.entity.purchase;

import com.alibou.security.project.entity.Vendor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


public class InvoicePurch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double total=0.0;

//    @Column(nullable = false)
    private Double discount=0.0;

//    @Column(nullable = false)
    private int flag=0;

//    @Column(nullable = false)
    private Long gen;

    @ManyToOne
    private Vendor vendor;

    private String serv;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    // Getters and Setters

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }


}
