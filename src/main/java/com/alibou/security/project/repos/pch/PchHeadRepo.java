package com.alibou.security.project.repos.pch;
import com.alibou.security.project.entity.pch.PchDetail;
import com.alibou.security.project.entity.pch.PchHead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PchHeadRepo extends JpaRepository<PchHead, Long> {
    @Query(value = "SELECT * FROM pch_head WHERE DATE_FORMAT(created_at, '%Y-%m') = DATE_FORMAT(CURDATE(), '%Y-%m') ORDER by created_at DESC",nativeQuery = true)
    List<PchHead> InvoicesByMonth();


    @Query(value = "SELECT * FROM pch_head WHERE WEEK(created_at) = WEEK(CURDATE()) ORDER by created_at DESC",nativeQuery = true)
    List<PchHead> InvoicesByWeek();

    @Query(value = "SELECT * FROM pch_head WHERE DATE(created_at) = CURDATE() ORDER by created_at DESC",nativeQuery = true)
    List<PchHead> InvoicesByDay();

    @Query(value = "SELECT * FROM pch_head\n" +
            "WHERE created_at >= ? AND created_at <= ? ORDER BY created_at DESC;",nativeQuery = true)
    List<PchHead> InvoicesBetweenDates(String from,String to);


}
