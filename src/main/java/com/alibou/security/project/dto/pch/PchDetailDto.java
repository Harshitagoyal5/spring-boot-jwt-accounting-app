package com.alibou.security.project.dto.pch;

import com.alibou.security.project.entity.Product;
import com.alibou.security.project.entity.pch.PchHead;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PchDetailDto {


    private Long id;
    @JsonProperty("product_id")
    private Long productId;
    private String code;
    private String title;
    private Long cateId;
    private Long unitId;
    private Double price;
    private int qty;
    private Double amt;
    @JsonProperty("pch_head_id")
    private Long pchHead;
    private String cate;
    private String unit;
}
