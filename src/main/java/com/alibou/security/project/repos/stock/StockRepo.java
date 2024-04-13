package com.alibou.security.project.repos.stock;

import com.alibou.security.project.entity.stock.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepo extends JpaRepository<Stock,Long> {
    @Query(value = "UPDATE `stock` SET `cost`=?,`sale_price`=? WHERE id=?",nativeQuery = true)
    void UpdateItemPrice(Double cost,Double price,Long id);
}
