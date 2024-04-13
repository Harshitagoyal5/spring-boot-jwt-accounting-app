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
@Table(name = "trans_view")
public class TransView {
    @Id
    private Long id;
    private Double amount;
    private String name;
    private Long to_id;
    private Long from_id;
    private Long payment_id;
    private Long opts_id;
    private LocalDateTime created_at;
}
