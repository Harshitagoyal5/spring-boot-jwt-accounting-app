package com.alibou.security.project.serv;

import com.alibou.security.project.entity.Accounts;
import com.alibou.security.project.repos.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServ {
    @Autowired
    AccountRepo repo;

    public Accounts insert(Accounts entry){
        return repo.save(entry);
    }

    public List<Accounts> getAll(){
        return repo.findAll();
    }
}
