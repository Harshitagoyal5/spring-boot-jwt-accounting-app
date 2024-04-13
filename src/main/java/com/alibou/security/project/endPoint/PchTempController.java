package com.alibou.security.project.endPoint;

import com.alibou.security.payload.DbResponseData;
import com.alibou.security.payload.Errors;
import com.alibou.security.payload.ResponseModel;
import com.alibou.security.payload.Result;
import com.alibou.security.project.request.ParamReq;
import com.alibou.security.project.request.TempRequest;
import com.alibou.security.project.resp.pch.PchTempDetailResponse;
import com.alibou.security.project.resp.pch.PchTempHeadResponse;
import com.alibou.security.project.serv.pch.PchTempServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1/temp")
public class PchTempController {
    @Autowired
    PchTempServ pchTempServ;

    @PostMapping("/insert")
    public ResponseEntity<ResponseModel> Insert(@RequestBody TempRequest tempRequest) throws SQLException {
        var response = pchTempServ.insertTempHeadAndDetails(tempRequest.getInvoicePurch(), tempRequest.getTempPurchDetails());
        ResponseModel re = new ResponseModel();
        re.setData(response);
        Result result = new Result();
        result.setErrNo(0);
        result.setErrMessage("Done");
        re.setResult(result);
        return ResponseEntity.ok(re);
    }


    @GetMapping("/details")
    public ResponseEntity<ResponseModel> getDet(@RequestBody ParamReq paramReq) throws SQLException {

        PchTempDetailResponse pchTempDetailResponse =new PchTempDetailResponse();
        ResponseModel responseModel = new ResponseModel<>();
        ResponseEntity<ResponseModel> response;
        Result result = new Result();
        try {
            int chk = pchTempServ.CheckIsExst(paramReq.getPam());
            if (chk == 0) {
                result.setErrNo(2001);
                result.setErrMessage("not found");
                responseModel.setResult(result);
                responseModel.setData(null);
                response = new ResponseEntity<>(
                        responseModel, HttpStatus.OK
                );
                return response;
            }

            var ret = pchTempServ.getDetailsOfInvoice(paramReq.getPam());
            pchTempDetailResponse.setList(ret);
            responseModel.setData(pchTempDetailResponse);

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

    @GetMapping("/all")
    public ResponseEntity<ResponseModel> getAll() throws SQLException {

        PchTempHeadResponse pchResponse =new PchTempHeadResponse();
        ResponseModel responseModel = new ResponseModel<>();
        ResponseEntity<ResponseModel> response;
        Result result = new Result();
        try {


            var ret = pchTempServ.getAllInvoice();

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


   // public ResponseEntity<ResponseModel> getReady()
}