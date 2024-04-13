package com.alibou.security.project.repos.pch;

import com.alibou.security.project.entity.pch.PchDetail;
import com.alibou.security.project.entity.pch.PchTempDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PchDetailRepo extends JpaRepository<PchDetail, Long> {


    @Query(value = "select * FROM pch_detail WHERE pch_head_id=? ",nativeQuery = true)
    List<PchDetail> GetDetailsOfInvoice(Long i);

}
