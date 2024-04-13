package com.alibou.security.project.serv;

import com.alibou.security.project.entity.Vendor;
import com.alibou.security.project.repos.VendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VendorServ {
    @Autowired
    VendorRepo repo;

    public Vendor insert(Vendor entry){
        return repo.save(entry);
    }

    public List<Vendor> getAll(){
        return repo.findAll();
    }
}
