package com.alibou.security.project.repos.views;

import com.alibou.security.project.entity.views.StockMoveView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockMoveViewRepo extends JpaRepository<StockMoveView, Long> {
    @Query(value = "SELECT * FROM `movement_stock_view` ORDER by created_at DESC",nativeQuery = true)
    List<StockMoveView> GetAllMovements();
}
//SELECT * FROM `movement_stock_view` ORDER by created_at DESC;