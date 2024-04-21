package com.alibou.security.project.repos.sale;

import com.alibou.security.project.entity.sale.SaleHead;
import com.alibou.security.project.entity.views.MainStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleHeadRepo extends JpaRepository<SaleHead, Long> {

    @Query(value = "SELECT * FROM `sale_head` ORDER BY id DESC",nativeQuery = true)
    List<SaleHead> getAllDesc();

}
