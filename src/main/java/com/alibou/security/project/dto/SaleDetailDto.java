package com.alibou.security.project.dto;

import com.alibou.security.project.entity.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("code")
    private String code;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("qty")
    private int qty;
    @JsonProperty("amt")
    private Double amt;
}
