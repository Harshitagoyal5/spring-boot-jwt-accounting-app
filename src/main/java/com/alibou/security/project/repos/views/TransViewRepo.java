package com.alibou.security.project.repos.views;

import com.alibou.security.project.entity.views.SaleDetailView;
import com.alibou.security.project.entity.views.TransView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransViewRepo extends JpaRepository<TransView, Long> {
    @Query(value = "SELECT * FROM `trans_view` ORDER by created_at DESC",nativeQuery = true)
    List<TransView> GetAllTrans();
}
