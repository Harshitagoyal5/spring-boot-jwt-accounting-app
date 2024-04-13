package com.alibou.security.project.repos.views;

import com.alibou.security.project.entity.pch.PchDetail;
import com.alibou.security.project.entity.views.PchDetailView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PchDetailViewRepo extends JpaRepository<PchDetailView, Long> {
    @Query(value = "SELECT * FROM `pch_detail_view` WHERE head=?",nativeQuery = true)
    List<PchDetailView> GetDetailsOfInvoice(Long i);
}
