package com.alibou.security.project.dto.pch;

import com.alibou.security.project.entity.Vendor;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PchHeadDto {
    private Long id;
    private Double total;
    private Double discount;
    private Long temp;
    @JsonProperty("vendor_id")
    private Long vendorId;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
}
