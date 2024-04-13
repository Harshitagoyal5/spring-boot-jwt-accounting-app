package com.alibou.security.project.entity.pch;

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
@Entity
@Table
public class PchTempHead {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//=LocalDateTime.now().hashCode()
    private Double total=0.0;
    @JsonProperty("vendor_id")
    private Long vendorId;
    private int state=0;

    @Column(updatable = false)
    private LocalDateTime createdAt;
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
