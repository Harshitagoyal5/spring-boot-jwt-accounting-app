package com.alibou.security.project.endPoint;

import com.alibou.security.payload.ResponseModel;
import com.alibou.security.payload.Result;
import com.alibou.security.project.request.ParamReq;
import com.alibou.security.project.request.TempRequest;
import com.alibou.security.project.request.VerRequest;
import com.alibou.security.project.resp.VerInvoiceResponse;
import com.alibou.security.project.resp.pch.PchDetailResponse;
import com.alibou.security.project.resp.pch.PchHeadResponse;
import com.alibou.security.project.resp.pch.PchTempDetailResponse;
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

    @PostMapping("/details")
    public ResponseEntity<ResponseModel> getDet(@RequestBody ParamReq paramReq) throws SQLException {

        PchDetailResponse pchResponse =new PchDetailResponse();
        ResponseModel responseModel = new ResponseModel<>();
        ResponseEntity<ResponseModel> response;
        Result result = new Result();
        try {
            boolean chk = pchServ.isExs(paramReq.getPam());
            System.out.println(chk);
            if (!chk) {
                result.setErrNo(2001);
                result.setErrMessage("not found");
                responseModel.setResult(result);
                responseModel.setData(null);
                response = new ResponseEntity<>(
                        responseModel, HttpStatus.OK
                );
                return response;
            }

            var ret = pchServ.getDetailsOfInvView(paramReq.getPam());
            pchResponse.setList(ret);
            responseModel.setData(pchResponse);

            result.setErrNo(0);
            result.setErrMessage("Done");
            responseModel.setResult(result);
            return ResponseEntity.ok(responseModel);
        }
        catch (Exception exception) {
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
    @PostMapping("/all")
    public ResponseEntity<ResponseModel> getAll() throws SQLException {

        PchHeadResponse pchResponse =new PchHeadResponse();
        ResponseModel responseModel = new ResponseModel<>();
        ResponseEntity<ResponseModel> response;
        Result result = new Result();
        try {

            var ret = pchServ.getHeadsInvView();
            pchResponse.setList(ret);
            responseModel.setData(pchResponse);

            result.setErrNo(0);
            result.setErrMessage("Done");
            responseModel.setResult(result);
            return ResponseEntity.ok(responseModel);
        }
        catch (Exception exception) {
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



}
