package com.alibou.security.project.serv;

import com.alibou.security.project.entity.Cate;
import com.alibou.security.project.repos.CateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CateServ {
    @Autowired
    CateRepo cateRepo;

   public Cate insert(Cate cate){
       return cateRepo.save(cate);
   }

   public List<Cate> getAll(){
       return cateRepo.findAll();
   }
}
