package com.alibou.security.project.entity.views;

import com.alibou.security.project.entity.Cate;
import com.alibou.security.project.entity.Product;
import com.alibou.security.project.entity.Unit;
import jakarta.persistence.*;
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
@Table(name = "main_stock_view")
public class MainStock {

    @Id
    private Long id;
    private int qty;
    private Double cost;
    private Double last_buy;
    private Double sale_price;
    private String cate;
    private Long cate_id;
    private String unit;
    private String product;
    private String code;
    private String barcode;
    private LocalDateTime created_at;

}
