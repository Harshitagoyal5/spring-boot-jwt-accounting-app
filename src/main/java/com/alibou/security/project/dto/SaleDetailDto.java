package com.alibou.security.project.dto;

import com.alibou.security.project.entity.Product;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleDetailDto {
    private Long product_id;
    private Double price;
    private int qty;
    private Double amt;
}
