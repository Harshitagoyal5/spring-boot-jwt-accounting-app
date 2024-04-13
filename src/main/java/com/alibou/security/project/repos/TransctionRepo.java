package com.alibou.security.project.repos;

import com.alibou.security.project.entity.Transction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransctionRepo extends JpaRepository<Transction, Long> {
}
