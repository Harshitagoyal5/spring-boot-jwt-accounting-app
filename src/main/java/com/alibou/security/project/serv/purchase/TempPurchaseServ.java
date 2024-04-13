package com.alibou.security.project.serv.purchase;

import com.alibou.security.project.entity.purchase.TempInvoicePurch;
import com.alibou.security.project.entity.purchase.TempPurchDetails;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

//@Service
public class TempPurchaseServ {
//    @Autowired
//    TempInvReop tempInvReop;
//    @Autowired
//    TempDetRepo tempDetRepo;
//
//
//    public Collection<TempInvoicePurch> get_AllInvoice() {
//        return tempInvReop.AllInvoice();
//
//    }
//
//    public Collection<TempInvoicePurch> get_Non_AllInvoice() {
//        return tempInvReop.AllNonInvoice();
//
//    }
//
//
//
//    public Collection<TempPurchDetails> get_ByInvoice(int id_invoice) {
//        Collection<TempPurchDetails> list = tempDetRepo.findByInvoice(id_invoice);
//        return list;
//    }
//
//    public List<TempInvoicePurch> itemsTemp() {
//        return tempInvReop.findAll();
//    }
//
//
////    @Transactional
////    public void insertPurchaseBillWithItems(TempInvoicePurch invoicePurch, List<TempPurchDetails> tempPurchDetails) {
////        var x = tempInvReop.save(invoicePurch);
////        for (TempPurchDetails item : tempPurchDetails) {
//////            item.setInvoicePurch(invoicePurch);
////            item.setInv_id(x.getId());
////            String cate = item.getCate().toString();
////            String code = item.getCode();
////            String own = cate + "K" + code;
////            item.setCode(own);
////            tempDetRepo.save(item);
////        }
////    }
}
