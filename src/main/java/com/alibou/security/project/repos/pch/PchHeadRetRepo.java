package com.alibou.security.project.repos.pch;
import com.alibou.security.project.entity.pch.PchHeadRet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PchHeadRetRepo extends JpaRepository<PchHeadRet, Long> {

}
