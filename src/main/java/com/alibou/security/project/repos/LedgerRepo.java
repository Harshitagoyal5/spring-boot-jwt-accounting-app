package com.alibou.security.project.repos;

import com.alibou.security.project.entity.Ledger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LedgerRepo   extends JpaRepository<Ledger, Long> {
}
