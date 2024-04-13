package com.alibou.security.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoicePurchDto {

    private Long id;
    private Double total;
    private Double discount;
    private Long gen;
    private Long vendor;
    private String serv;
    private LocalDateTime created_at;
    private LocalDateTime updatedAt;
}
