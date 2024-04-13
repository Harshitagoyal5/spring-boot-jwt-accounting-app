package com.alibou.security.project.serv.purchase;

import com.alibou.security.project.dto.InvoicePurchView;
import com.alibou.security.project.entity.purchase.InvoicePurch;
import com.alibou.security.project.entity.purchase.PurchDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Collection;
import java.util.List;

//@Service
public class PurchaseServ {
//    @Autowired
//    InvoicePurchRepo invoicePurchRepo;
//    @Autowired
//    PurchDetailsRepo purchDetailsRepo;
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//    @Autowired
//    private InvoicePurchViewRepo invoicePurchViewRepo;


//
//    public String doInvoiceInfoJson(int invoiceId, double discount) throws SQLException {
//        System.out.println(invoiceId);
//        CallableStatement cs = jdbcTemplate.getDataSource().getConnection().prepareCall("{call do_verified_inv(?,?,?)}");
//        cs.setInt(1, invoiceId);
//        cs.setDouble(2,discount);
//        cs.registerOutParameter(3, Types.VARCHAR);
//        cs.execute();
//        return cs.getString(3);
//    }
//
//    public String getDetailsOfInvoice(int invoiceId) throws SQLException {
//       // System.out.println(invoiceId);
//        CallableStatement cs = jdbcTemplate.getDataSource().getConnection().prepareCall("{CALL get_view_details(?,?)}");
//        cs.setInt(1, invoiceId);
//        cs.registerOutParameter(2, Types.VARCHAR);
//        cs.execute();
//        return cs.getString(2);
//    }
//
//    public List<InvoicePurch> allItems() {
//        return invoicePurchRepo.findAll();
//    }
//
//    public InvoicePurch get_inv_det(Long i) {
//        return invoicePurchRepo.getReferenceById(i);
//
//    }
//
//    public List<PurchDetails> get_det(Long i) {
//        return purchDetailsRepo.getDet(i);
//
//    }
//    public List<InvoicePurchView> getView() {
//        return invoicePurchViewRepo.getAll();
//
//    }
}
