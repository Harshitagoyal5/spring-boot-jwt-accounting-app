package com.alibou.security.project.repos;

import com.alibou.security.project.entity.Opts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptsRepo  extends JpaRepository<Opts, Long> {
}
