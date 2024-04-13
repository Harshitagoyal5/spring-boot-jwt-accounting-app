package com.alibou.security.project.serv;

import com.alibou.security.project.entity.Product;
import com.alibou.security.project.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServ {

    @Autowired
    ProductRepo productRepo;

    public void save(Product product){
        var pro =product.getCate().getId()+"K"+ product.getCode() ;
       var x= productRepo.save(product);

    }

    public List<Product> getAll(){
        return productRepo.findAll();
    }

}
