package com.alibou.security.project.repos.pch;
import com.alibou.security.project.entity.pch.PchTempDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PchTempDetailRepo extends JpaRepository<PchTempDetail, Long> {
    @Query(value = "select * FROM pch_temp_detail WHERE temp_id=? ",nativeQuery = true)
    List<PchTempDetail> GetDetailsOfInvoice(Long i);
}
