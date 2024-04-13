package com.alibou.security.project.serv.stock;

import com.alibou.security.project.entity.stock.Stock;
import com.alibou.security.project.entity.views.MainStock;
import com.alibou.security.project.entity.views.StockMoveView;
import com.alibou.security.project.repos.stock.StockRepo;
import com.alibou.security.project.repos.views.MainStockRepo;
import com.alibou.security.project.repos.views.StockMoveViewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServ {
    @Autowired
    MainStockRepo mainStockRepo;

    @Autowired
    StockMoveViewRepo stockMoveViewRepo;
    @Autowired
    StockRepo stockRepo;


    public boolean isExist(Long i){
        var chk=mainStockRepo.findById(i);
        if(chk.isPresent()){
            return true;
        }
        return false;
    }

  public Stock UpdatePrice(Double cost,Double price,Long id) {
       Stock stock= stockRepo.findById(id).get();
       stock.setCost(cost);
       stock.setSale_price(price);
       stockRepo.save(stock);

       return stock;
       // stockRepo.UpdateItemPrice(cost,price,id);
  }

  public List<MainStock> getAllItemsWithNoPrice(){
      return mainStockRepo.GetAllItemsWithNoPrice();
  }
    public List<MainStock> getAllItemsAvailable(){
        return mainStockRepo.GetAllItemsAvailable();

    }
    public List<MainStock> getAllItemsNonAvailable(){
        return mainStockRepo.GetAllItemsNonAvailable();
    }

    public List<StockMoveView> getAllMovements(){
      return stockMoveViewRepo.GetAllMovements();
    }  public List<MainStock> getAllItemsByCate(Long c){
      return mainStockRepo.GetAllItemsByCate(c);
    }

}
