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
@Table(name = "movement_stock_view")
public class StockMoveView {
    @Id
    private Long id;
    private int qty_in;    private int qty_out;
    private Double price;
    private String cate;
    private Long cate_id;
    private String unit;
    private String product;    private Long product_id;
    private String code;
    private String barcode;
    private LocalDateTime created_at;
}
