package com.alibou.security.project.repos.views;

import com.alibou.security.project.entity.views.SaleDetailView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleDetailViewRepo extends JpaRepository<SaleDetailView, Long> {
    @Query(value = "SELECT * FROM `sale_detail_view` WHERE sale_id=?",nativeQuery = true)
    List<SaleDetailView> GetDetailsOfInvoice(Long i);

}
