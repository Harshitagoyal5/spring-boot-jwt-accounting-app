package com.alibou.security.project.endPoint;

import com.alibou.security.payload.ResponseModel;
import com.alibou.security.payload.Result;
import com.alibou.security.project.entity.Accounts;
import com.alibou.security.project.entity.Cate;
import com.alibou.security.project.entity.Unit;
import com.alibou.security.project.entity.Vendor;
import com.alibou.security.project.entity.views.MainStock;
import com.alibou.security.project.repos.views.MainStockRepo;
import com.alibou.security.project.resp.AccountResponse;
import com.alibou.security.project.resp.CateResponse;
import com.alibou.security.project.resp.UnitResponse;
import com.alibou.security.project.resp.VendorResponse;
import com.alibou.security.project.serv.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/main")
public class GeneralController {

    @Autowired
    private AccountServ accountServ;

    @Autowired
    private UnitServ unitServ;
    @Autowired
    private VendorServ vendorServ;
    @Autowired
    private CateServ cateServ;

    @Autowired
    private MainStockRepo mainStockRepo;

    @PostMapping("/stock/all")
    public ResponseEntity<ResponseModel> getAllStock() {
        List<MainStock> mainStocks=mainStockRepo.findAll();

        ResponseModel re = new ResponseModel<>();
        re.setData(mainStocks);
        Result result = new Result();
        //result.setStatus(true);
        result.setErrNo(0);
        result.setErrMessage("Done");
        re.setResult(result);
        return ResponseEntity.ok(re);
    }

    @PostMapping("/acc/all")
    public ResponseEntity<ResponseModel<AccountResponse>> getAllAccount() {
        List<Accounts> acc=  accountServ.getAll();
        AccountResponse response=new AccountResponse();
        response.setList(acc);
        ResponseModel re = new ResponseModel<AccountResponse>();
        re.setData(response);
        Result result = new Result();
        //result.setStatus(true);
        result.setErrNo(0);
        result.setErrMessage("Done");
        re.setResult(result);
        return ResponseEntity.ok(re);
    }
    @PostMapping("/acc/insert")
    public ResponseEntity<ResponseModel<Accounts>> insertAccount(@RequestBody Accounts body ) {
        Accounts ins=accountServ.insert(body);
        ResponseModel re = new ResponseModel<>();
        re.setData(ins);
        Result result = new Result();
        //result.setStatus(true);
        result.setErrNo(0);
        result.setErrMessage("Done");
        re.setResult(result);
        return ResponseEntity.ok(re);
    }

    @PostMapping("/unit/all")
    public ResponseEntity<ResponseModel<UnitResponse>> getAllUnit() {
        List<Unit> list=  unitServ.getAll();
        UnitResponse response=new UnitResponse();
        response.setList(list);
        ResponseModel re = new ResponseModel<UnitResponse>();
        re.setData(response);
        Result result = new Result();
        //result.setStatus(true);
        result.setErrNo(0);
        result.setErrMessage("Done");
        re.setResult(result);
        return ResponseEntity.ok(re);
    }
    @PostMapping("/unit/insert")
    public ResponseEntity<ResponseModel<Unit>> insertUnit(@RequestBody Unit body ) {
        Unit ins=unitServ.insert(body);
        ResponseModel re = new ResponseModel<>();
        re.setData(ins);
        Result result = new Result();
        //result.setStatus(true);
        result.setErrNo(0);
        result.setErrMessage("Done");
        re.setResult(result);
        return ResponseEntity.ok(re);
    }

    @PostMapping("/vendor/all")
    public ResponseEntity<ResponseModel<VendorResponse>> getAllVendor() {
        List<Vendor> list=  vendorServ.getAll();
        VendorResponse response=new VendorResponse();
        response.setList(list);
        ResponseModel re = new ResponseModel<VendorResponse>();
        re.setData(response);
        Result result = new Result();
        //result.setStatus(true);
        result.setErrNo(0);
        result.setErrMessage("Done");
        re.setResult(result);
        return ResponseEntity.ok(re);
    }
    @PostMapping("/vendor/insert")
    public ResponseEntity<ResponseModel<Vendor>> insertVendor(@RequestBody Vendor body ) {
        Vendor ins=vendorServ.insert(body);
        ResponseModel re = new ResponseModel<>();
        re.setData(ins);
        Result result = new Result();
        //result.setStatus(true);
        result.setErrNo(0);
        result.setErrMessage("Done");
        re.setResult(result);
        return ResponseEntity.ok(re);
    }


    @PostMapping("/cate/all")
    public ResponseEntity<ResponseModel<CateResponse>> getAllCate() {
        List<Cate> list=  cateServ.getAll();
        CateResponse cateResponse=new CateResponse();
       cateResponse.setCates(list);
        ResponseModel re = new ResponseModel<CateResponse>();

        re.setData(cateResponse);
        Result result = new Result();
        //result.setStatus(true);
        result.setErrNo(0);
        result.setErrMessage("Done");
        re.setResult(result);
        return ResponseEntity.ok(re);
    }
    @PostMapping("/cate/insert")
    public ResponseEntity<ResponseModel<Cate>> insertCate(@RequestBody Cate cate ) {
        Cate ins=cateServ.insert(cate);
        ResponseModel re = new ResponseModel<>();
        re.setData(ins);
        Result result = new Result();
        //result.setStatus(true);
        result.setErrNo(0);
        result.setErrMessage("Done");
        re.setResult(result);
        return ResponseEntity.ok(re);
    }
}
