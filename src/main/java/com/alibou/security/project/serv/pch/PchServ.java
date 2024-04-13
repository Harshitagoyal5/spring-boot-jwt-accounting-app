package com.alibou.security.project.serv.pch;

import com.alibou.security.project.entity.pch.PchDetail;
import com.alibou.security.project.entity.pch.PchHead;
import com.alibou.security.project.entity.pch.PchTempHead;
import com.alibou.security.project.entity.views.PchDetailView;
import com.alibou.security.project.entity.views.PchHeadView;
import com.alibou.security.project.repos.pch.PchDetailRepo;
import com.alibou.security.project.repos.pch.PchHeadRepo;
import com.alibou.security.project.repos.pch.PchTempHeadRepo;
import com.alibou.security.project.repos.views.PchDetailViewRepo;
import com.alibou.security.project.repos.views.PchHeadViewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Service
public class PchServ {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PchHeadRepo pchHeadRepo;

    @Autowired
    private PchDetailRepo pchDetailRepo;
    @Autowired
    private PchDetailViewRepo pchDetailViewRepo;
    @Autowired
    private PchHeadViewRepo pchHeadViewRepo;
    @Autowired
    private PchTempHeadRepo pchTempHeadRepo;

    public String doInvoiceInfoJson(Long invoiceId, double discount) throws SQLException {
        System.out.println(invoiceId);
        CallableStatement cs = jdbcTemplate.getDataSource().getConnection().prepareCall("{call do_verified_inv(?,?,?)}");
        cs.setLong(1, invoiceId);
        cs.setDouble(2, discount);
        cs.registerOutParameter(3, Types.VARCHAR);
        cs.execute();
        return cs.getString(3);
    }

    public boolean checkStateTemp(Long i){
       var x= pchTempHeadRepo.checkInvoice(i);
       if(x.isPresent()){
           return true;
       }
       else return false;
    }

    public List<PchHead> getHeadsInv(){
        List<PchHead> pchHeads=  pchHeadRepo.findAll();
        return  pchHeads;
    }
    public List<PchHeadView> getHeadsInvView(){
        List<PchHeadView> pchHeads=  pchHeadViewRepo.findAll();
        return  pchHeads;
    }

    public boolean isExs(Long i){
        var ex= pchHeadRepo.FindByTemp(i);
        if(ex.isPresent()){
            return true;
        }
        return false;
    }

    public List<PchDetail> getDetailsOfInv(Long i){
        List<PchDetail> pchDetails=pchDetailRepo.GetDetailsOfInvoice(i);
        return pchDetails;
    }
    public List<PchDetailView> getDetailsOfInvView(Long i){
        List<PchDetailView> pchDetails=pchDetailViewRepo.GetDetailsOfInvoice(i);
        return pchDetails;
    }
}
