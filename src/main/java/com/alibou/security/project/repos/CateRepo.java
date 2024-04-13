package com.alibou.security.project.repos;

import com.alibou.security.project.entity.Cate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CateRepo   extends JpaRepository<Cate, Long> {
}
