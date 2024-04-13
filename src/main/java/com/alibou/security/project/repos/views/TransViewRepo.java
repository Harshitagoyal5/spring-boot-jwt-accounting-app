package com.alibou.security.project.repos.views;

import com.alibou.security.project.entity.views.TransView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransViewRepo extends JpaRepository<TransView, Long> {
}
