package com.alibou.security.project.repos;

import com.alibou.security.project.entity.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesRepo extends JpaRepository<Expenses, Long> {
}
