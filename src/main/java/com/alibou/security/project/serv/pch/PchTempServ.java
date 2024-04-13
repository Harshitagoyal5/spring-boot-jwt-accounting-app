package com.alibou.security.project.serv.pch;

import com.alibou.security.project.entity.pch.PchTempDetail;
import com.alibou.security.project.entity.pch.PchTempHead;
import com.alibou.security.project.entity.purchase.TempPurchDetails;
import com.alibou.security.project.repos.pch.PchTempDetailRepo;
import com.alibou.security.project.repos.pch.PchTempHeadRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PchTempServ {
    @Autowired
    PchTempDetailRepo pchTempDetailRepo;
    @Autowired
    PchTempHeadRepo pchTempHeadRepo;

    @Transactional
    public int insertTempHeadAndDetails(PchTempHead invoicePurch, List<PchTempDetail> tempPurchDetails) {
        int id;
        try {
            var local = LocalDateTime.now();
            // String conc= String.valueOf(local.getDayOfYear())+String.valueOf(local.getDayOfMonth())+String.valueOf(local.getDayOfWeek())+String.valueOf(local.getNano());
            id = local.getNano();
            invoicePurch.setId(id);
            var x = pchTempHeadRepo.save(invoicePurch);
            for (PchTempDetail item : tempPurchDetails) {
                item.setTempId(id);
                String cate = item.getCate().toString();
                String code = item.getCode();
                String own = cate + "K" + code;
                item.setCode(own);
                pchTempDetailRepo.save(item);
            }
            return id;
        } catch (Exception e) {
            throw e;
        }

    }

    public int CheckIsExst(Long i) {
        try {
            // var head=pchTempHeadRepo.findById(i).get();
//    var head=pchTempHeadRepo.checkInvoice(i).get();
            var head = pchTempHeadRepo.existsById(i);

            if (head) {
                return 1;
            } else return 0;
        } catch (Exception e) {
            return 0;
        }
    }

public List<PchTempHead> getAllInvoice(){
        var all= pchTempHeadRepo.findAll();
        return all;
}
    public List<PchTempDetail> getDetailsOfInvoice(Long i) {
        var det = pchTempDetailRepo.GetDetailsOfInvoice(i);
        return det;
    }

}
