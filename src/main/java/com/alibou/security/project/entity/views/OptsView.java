package com.alibou.security.project.entity.views;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Immutable
@Table(name = "opts_view")
public class OptsView {
    @Id
    private Long id;
    private int num;
    private String name;
    private String to_acc;
    private String from_acc;
    private Long to_id;
    private Long from_id;
}
