package com.alibou.security.project.repos.pch;
import com.alibou.security.project.entity.pch.PchDetailRet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PchDetailRetRepo extends JpaRepository<PchDetailRet, Long> {

}
