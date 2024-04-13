package com.alibou.security.project.endPoint;

import com.alibou.security.payload.ResponseModel;
import com.alibou.security.payload.Result;
import com.alibou.security.project.request.TempRequest;
import com.alibou.security.project.request.VerRequest;
import com.alibou.security.project.resp.VerInvoiceResponse;
import com.alibou.security.project.serv.pch.PchServ;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;


@RestController
@RequestMapping("/api/v1/pch")
public class PurchaseController {


    @Autowired
    PchServ pchServ;

    @PostMapping("/insert")
    public ResponseEntity<ResponseModel> Insert(@RequestBody VerRequest verRequest) throws SQLException {

        ResponseModel responseModel = new ResponseModel<>();
        ResponseEntity<ResponseModel> response;
        Result result = new Result();
        try{
           boolean headTemp = pchServ.checkStateTemp(verRequest.getId());
           if(!headTemp){
               result.setErrNo(2001);
               result.setErrMessage("Not Found");
               responseModel.setResult(result);
               responseModel.setData(null);
               response = new ResponseEntity<>(
                       responseModel, HttpStatus.OK
               );
               return response;
           }

    var x = pchServ.doInvoiceInfoJson(verRequest.getId(),verRequest.getDiscount());

    VerInvoiceResponse verInvoiceResponse=new VerInvoiceResponse();
    JsonObject jsonObject = JsonParser.parseString(x)
            .getAsJsonObject();
            verInvoiceResponse.setCr(String.valueOf(jsonObject.get("created_at")));
            verInvoiceResponse.setDiscount(jsonObject.get("discount").getAsDouble());
            verInvoiceResponse.setTotal(jsonObject.get("total").getAsDouble());
            verInvoiceResponse.setTemp(jsonObject.get("temp").getAsLong());
            verInvoiceResponse.setId(jsonObject.get("id").getAsLong());
            verInvoiceResponse.setVendorId(jsonObject.get("vendor_id").getAsInt());

    ResponseModel re = new ResponseModel<VerInvoiceResponse>();
    re.setData(verInvoiceResponse);
    result.setErrNo(0);
    result.setErrMessage("Done");
    re.setResult(result);

    return ResponseEntity.ok(re);
}catch (Exception exception){
    exception.printStackTrace();
    result.setErrNo(100);
    System.out.println(exception.getMessage());
    result.setErrMessage("something want wrong");
    responseModel.setResult(result);
    responseModel.setData(null);
    response = new ResponseEntity<>(
            responseModel, HttpStatus.OK
    );
}
        return response;
    }


    //getAll
    //getDetails


}
//    @PostMapping("/")
//    public ResponseEntity<ResponseModel> doVer(@RequestBody VerRequest verRequest) throws SQLException {
//        var x= purchaseServ.doInvoiceInfoJson(verRequest.getId(), verRequest.getDiscount());
////        System.out.println(x);
//        VerInvoiceResponse response=new VerInvoiceResponse();
//        JsonObject jsonObject = JsonParser.parseString(x)
//                .getAsJsonObject();
//        response.setCr(String.valueOf(jsonObject.get("created_at")));
//        response.setDiscount(jsonObject.get("discount").getAsDouble());
//        response.setTotal(jsonObject.get("total").getAsDouble());
//        response.setGen(jsonObject.get("gen").getAsLong());
//        response.setId(jsonObject.get("id").getAsLong());
//        response.setVendorId(jsonObject.get("vendor_id").getAsInt());
//
//        ResponseModel re = new ResponseModel<VerInvoiceResponse>();
//        re.setData(response);
//        Result result = new Result();
//        result.setErrNo(0);
//        result.setErrMessage("Done");
//        re.setResult(result);
//        return ResponseEntity.ok(re);
//    }
//    @PostMapping("/detail")
//    public ResponseEntity<ResponseModel> getDet(@RequestBody VerRequest verRequest) throws SQLException {
//        var x= purchaseServ.getDetailsOfInvoice(verRequest.getId());
////        System.out.println(x);
//        DetailViewResponse response=new DetailViewResponse();
//        JsonObject jsonObject = JsonParser.parseString(x)
//                .getAsJsonObject();
////        response.setList(jsonObject.get('detlst').getAsJsonNull());
////        response.setCr(String.valueOf(jsonObject.get("created_at")));
////        response.setDiscount(jsonObject.get("discount").getAsDouble());
////        response.setTotal(jsonObject.get("total").getAsDouble());
////        response.setGen(jsonObject.get("gen").getAsLong());
////        response.setId(jsonObject.get("id").getAsLong());
////        response.setVendorId(jsonObject.get("vendor_id").getAsInt());
//
//        ResponseModel re = new ResponseModel<VerInvoiceResponse>();
//        re.setData(response);
//        Result result = new Result();
//        result.setErrNo(0);
//        result.setErrMessage("Done");
//        re.setResult(result);
//        return ResponseEntity.ok(re);
//    }
//
//    @PostMapping("/all")
//    public ResponseEntity<ResponseModel<InvoicesResponse>> getAll() {
//
//        var x= purchaseServ.allItems();
//        InvoicesResponse response=new InvoicesResponse();
//        List<InvoicePurchDto> xlist=new ArrayList<InvoicePurchDto>();
//        x.forEach(z-> xlist.add(
//                new InvoicePurchDto(z.getId(),z.getTotal(),z.getDiscount(),z.getGen(),
//                        z.getVendor().getId(),z.getServ(),z.getCreatedAt(),z.getUpdatedAt())));
//        response.setList(xlist);
//        ResponseModel re = new ResponseModel<InvoicesResponse>();
//        re.setData(response);
//        Result result = new Result();
//        result.setErrNo(0);
//        result.setErrMessage("Done");
//        re.setResult(result);
//        return ResponseEntity.ok(re);
//    }
//
//    @PostMapping("/view")
//    public ResponseEntity<ResponseModel<InvoiceViewResponse>> getAllView() {
//        var x= purchaseServ.getView();
//        InvoiceViewResponse response=new InvoiceViewResponse();
//        response.setList(x);
//        ResponseModel re = new ResponseModel<InvoicesResponse>();
//        re.setData(response);
//        Result result = new Result();
//        result.setErrNo(0);
//        result.setErrMessage("Done");
//        re.setResult(result);
//        return ResponseEntity.ok(re);
//    }
//
//
//    @PostMapping("/getdet")
//    public ResponseEntity<ResponseModel<DetailResponse>> getDetailsOfInvoice(@RequestBody ParamReq paramReq) {
//        var x= purchaseServ.get_det(paramReq.getPam().longValue());
//        Result result = new Result();
//        ResponseModel re = new ResponseModel<InvoicesResponse>();
//        DetailResponse response=new DetailResponse();
//        response.setList(x);
//        re.setData(response);
//        result.setErrNo(0);
//        result.setErrMessage("Done");
//        re.setResult(result);
//        return ResponseEntity.ok(re);
//
//    }