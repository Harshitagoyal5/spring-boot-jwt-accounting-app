package com.alibou.security.project.repos.views;

import com.alibou.security.project.entity.views.MainStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainStockRepo extends JpaRepository<MainStock, Long> {

    @Query(value = "SELECT * FROM `main_stock_view` WHERE qty>0 and sale_price=0 or cost=0 ORDER BY id DESC",nativeQuery = true)
    List<MainStock> GetAllItemsWithNoPrice();
    @Query(value = "SELECT * FROM `main_stock_view` WHERE qty>0 ORDER BY id DESC",nativeQuery = true)
    List<MainStock> GetAllItemsAvailable();
    @Query(value = "SELECT * FROM `main_stock_view` WHERE qty=0 and last_buy>0 ORDER BY id DESC",nativeQuery = true)
    List<MainStock> GetAllItemsNonAvailable();

    @Query(value = "SELECT * FROM `main_stock_view` WHERE qty>0 and sale_price>0 and cate_id=? ORDER BY id DESC",nativeQuery = true)
    List<MainStock> GetAllItemsByCate(Long c);
}
//SELECT * FROM `main_stock_view` WHERE qty >0 ORDER BY id DESC;
//SELECT * FROM `main_stock_view` WHERE qty=0 and last_buy>0 ORDER BY id DESC;
//SELECT * FROM `main_stock_view` WHERE qty >0 and sale_price>0 ORDER BY id DESC;
//SELECT * FROM `main_stock_view` WHERE qty >0 and sale_price=0 or cost=0 ORDER BY id DESC;
//SELECT * FROM `main_stock_view` WHERE last_buy=0 ORDER BY id DESC;