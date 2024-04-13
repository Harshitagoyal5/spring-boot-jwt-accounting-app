package com.alibou.security.project.entity.pch;

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
@Entity
@Table
public class PchTempDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cate;
    private Long unit;
    private String name;
    private String code;
    private String barcode;
    private Double price= 0.0;
    private int qty= 1;
    private Double amt;
    private int tempId;
}
