package com.alibou.security.project.repos.views;

import com.alibou.security.project.entity.views.PchTempDetailView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PchTempDetailViewRepo extends JpaRepository<PchTempDetailView, Long> {

}
