package com.alibou.security.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
public class InvoicePurchView {
    @Id
    private Long id;
    private Double total;
    private Double discount;
    private Long gen;
    @JsonProperty("vendor")
    private String name;
    private LocalDateTime created_at;
}
