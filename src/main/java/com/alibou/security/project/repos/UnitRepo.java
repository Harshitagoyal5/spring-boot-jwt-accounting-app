package com.alibou.security.project.repos;

import com.alibou.security.project.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepo   extends JpaRepository<Unit, Long> {
}
