package com.alibou.security.project.entity.views;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Immutable
@Table(name = "pch_detail_view")
public class PchDetailView {
    @Id
    private Long id;
    private int qty;private int head;
    private Double amt;
    private Double price;
    private String cate;
    private Long cate_id;
    private String unit;
    private String product;
    private Long product_id;
    private String code;
    private String barcode;
}
