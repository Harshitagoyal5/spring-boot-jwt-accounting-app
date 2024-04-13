package com.alibou.security.project.repos.sale;

import com.alibou.security.project.entity.sale.SaleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleDetailRepo extends JpaRepository<SaleDetail, Long> {
}
