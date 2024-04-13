package com.alibou.security.project.repos.sale;

import com.alibou.security.project.entity.sale.SaleTrack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleTrackRepo extends JpaRepository<SaleTrack, Long> {

}
