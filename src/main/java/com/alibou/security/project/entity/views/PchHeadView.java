package com.alibou.security.project.entity.views;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Immutable
@Table(name = "pch_head_view")
public class PchHeadView {
    @Id
    private Long id;
    private Long temp;
    private Long vendor_id;
    private String vendor;
    private Double total;
    private Double discount;
    private LocalDateTime created_at;

}
