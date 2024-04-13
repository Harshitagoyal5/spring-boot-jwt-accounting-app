package com.alibou.security.project.entity.views;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Immutable
@Table(name = "pch_temp_detail_view")
public class PchTempDetailView {
    @Id
    private Long id;
    private int qty;
    private Double amt;
    private Double price;
    private Long cate_id;
    private Long unit;
    private String name;
    private String cateName;
    private String unitName;
    private Long temp_id;
    private String code;
    private String barcode;
}
