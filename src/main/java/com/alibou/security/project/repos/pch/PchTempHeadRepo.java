package com.alibou.security.project.repos.pch;

import com.alibou.security.project.entity.pch.PchTempHead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface PchTempHeadRepo extends JpaRepository<PchTempHead, Long> {
    @Query(value = "select * FROM pch_temp_head WHERE state=0 and id=? ORDER by id DESC",nativeQuery = true)
  Optional<PchTempHead> checkInvoice(Long i);
}
