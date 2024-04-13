package com.alibou.security.project.repos.sale;

import com.alibou.security.project.entity.sale.SaleHead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleHeadRepo extends JpaRepository<SaleHead, Long> {

}
