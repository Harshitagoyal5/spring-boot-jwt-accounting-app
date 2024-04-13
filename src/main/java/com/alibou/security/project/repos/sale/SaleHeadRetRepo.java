package com.alibou.security.project.repos.sale;

import com.alibou.security.project.entity.sale.SaleHeadRet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleHeadRetRepo extends JpaRepository<SaleHeadRet, Long> {

}
