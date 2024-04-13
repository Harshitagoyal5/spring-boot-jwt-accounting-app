package com.alibou.security.project.repos.views;

import com.alibou.security.project.entity.pch.PchHead;
import com.alibou.security.project.entity.views.PchHeadView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PchHeadViewRepo extends JpaRepository<PchHeadView, Long> {
    @Query(value = "SELECT * FROM pch_head_view WHERE DATE_FORMAT(created_at, '%Y-%m') = DATE_FORMAT(CURDATE(), '%Y-%m') ORDER by created_at DESC",nativeQuery = true)
    List<PchHeadView> InvoicesByMonth();


    @Query(value = "SELECT * FROM pch_head_view WHERE WEEK(created_at) = WEEK(CURDATE()) ORDER by created_at DESC",nativeQuery = true)
    List<PchHeadView> InvoicesByWeek();

    @Query(value = "SELECT * FROM pch_head_view WHERE DATE(created_at) = CURDATE() ORDER by created_at DESC",nativeQuery = true)
    List<PchHeadView> InvoicesByDay();

    @Query(value = "SELECT * FROM pch_head_view\n" +
            "WHERE created_at >= ? AND created_at <= ? ORDER BY created_at DESC",nativeQuery = true)
    List<PchHeadView> InvoicesBetweenDates(String from,String to);

}
