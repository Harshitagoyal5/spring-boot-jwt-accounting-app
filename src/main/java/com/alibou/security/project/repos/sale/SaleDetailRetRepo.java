package com.alibou.security.project.repos.sale;

import com.alibou.security.project.entity.sale.SaleDetailRet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleDetailRetRepo extends JpaRepository<SaleDetailRet, Long> {

}
