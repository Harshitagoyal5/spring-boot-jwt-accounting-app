package com.alibou.security.project.serv;

import com.alibou.security.project.entity.Unit;
import com.alibou.security.project.repos.UnitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UnitServ {
    @Autowired
    UnitRepo repo;

    public Unit insert(Unit entry){
        return repo.save(entry);
    }

    public List<Unit> getAll(){
        return repo.findAll();
    }
}
