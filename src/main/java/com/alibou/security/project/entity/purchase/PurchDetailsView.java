package com.alibou.security.project.entity.purchase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class PurchDetailsView {
    private Long id;
    private String name;
    private String cate;
    private String unit;
    private String code;
    private Double price;
    private int qty;
    private Double amt;
    private Long gen;
    private Long inv_id;
}
