package com.alibou.security.project.repos;

import com.alibou.security.project.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    @Query("select u from Product u where u.code = ?1")
    Product findProductByCode(String code);
}
