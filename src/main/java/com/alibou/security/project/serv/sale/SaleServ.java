package com.alibou.security.project.serv.sale;

import com.alibou.security.project.dto.SaleDetailDto;
import com.alibou.security.project.entity.Product;
import com.alibou.security.project.entity.sale.SaleDetail;
import com.alibou.security.project.entity.sale.SaleHead;
import com.alibou.security.project.entity.views.SaleDetailView;
import com.alibou.security.project.repos.ProductRepo;
import com.alibou.security.project.repos.sale.SaleDetailRepo;
import com.alibou.security.project.repos.sale.SaleHeadRepo;
import com.alibou.security.project.repos.views.SaleDetailViewRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleServ {
    @Autowired
    SaleHeadRepo saleHeadRepo;
    @Autowired
    SaleDetailRepo saleDetailRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    SaleDetailViewRepo saleDetailViewRepo;


   public boolean isExsSale(Long i){
      var x= saleHeadRepo.findById(i);
      if(x.isPresent()){
          return true;
      }
       return false;
   }
    @Transactional
    public SaleHead createInvoice(SaleHead saleHead, List<SaleDetailDto> saleDetails){
       var oj= saleHeadRepo.save(saleHead);
        List<SaleDetail> details=new ArrayList<>();
       Long id= oj.getId();
       saleDetails.forEach(s->{
           Product product = productRepo.findProductByCode(s.getCode());
           SaleDetail saleDetail = new SaleDetail(null,product,s.getPrice(),s.getQty(),s.getAmt(),id);
           details.add(saleDetail);
       });
       saleDetailRepo.saveAll(details);

       return oj;
    }

    public List<SaleDetailView> getDetailInvoice(Long i){
        return  saleDetailViewRepo.GetDetailsOfInvoice(i);
    }
    public List<SaleHead>getAllInv(){
        return saleHeadRepo.getAllDesc();
    }
}
