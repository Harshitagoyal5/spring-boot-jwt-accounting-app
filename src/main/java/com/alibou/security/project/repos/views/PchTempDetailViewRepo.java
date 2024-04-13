package com.alibou.security.project.repos.views;

import com.alibou.security.project.entity.pch.PchTempDetail;
import com.alibou.security.project.entity.views.PchTempDetailView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PchTempDetailViewRepo extends JpaRepository<PchTempDetailView, Long> {
    @Query(value = "select * FROM pch_temp_detail_view WHERE temp_id=? ",nativeQuery = true)
    List<PchTempDetailView> GetDetailsOfInvoice(Long i);
}
