package com.alibou.security.project.repos;

import com.alibou.security.project.entity.SearchName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchNameRepo extends JpaRepository<SearchName, Long> {
}
