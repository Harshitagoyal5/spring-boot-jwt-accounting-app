package com.alibou.security.project.entity.purchase;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class TempPurchDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cate;
    private Long unit;
    private String name;
    private String code;
    private String barcode;
    private String nameOwn;
    private Double price= 0.0;
@JsonProperty("qty")
    private int Qty= 1;

    private Double amt;
    private Long inv_id;

}
