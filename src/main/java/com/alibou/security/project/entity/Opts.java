package com.alibou.security.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Opts")
public class Opts {
    @Id
    private Long id;
    private String name;
    private int num;

    @ManyToOne
    private Accounts from;
    @ManyToOne
    private Accounts to;


}
