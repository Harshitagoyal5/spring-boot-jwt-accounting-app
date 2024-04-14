package com.alibou.security.project.endPoint;

import com.alibou.security.payload.ResponseModel;
import com.alibou.security.payload.Result;
import com.alibou.security.project.request.ParamReq;
import com.alibou.security.project.request.SaleRequest;
import com.alibou.security.project.resp.sale.SaleDetailResponse;
import com.alibou.security.project.resp.sale.SaleHeadResponse;
import com.alibou.security.project.serv.sale.SaleServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
@RestController
@RequestMapping("/api/v1/sale")
public class SaleController {

    @Autowired
    SaleServ saleServ;
    @PostMapping("/insert")
    public ResponseEntity<ResponseModel> Insert(@RequestBody SaleRequest saleRequest) throws SQLException {

        var response = saleServ.createInvoice(saleRequest.getInvoiceSale(),saleRequest.getSaleDetails());
        ResponseModel re = new ResponseModel();
        re.setData(response);
        Result result = new Result();
        result.setErrNo(0);
        result.setErrMessage("Done");
        re.setResult(result);
        return ResponseEntity.ok(re);
    }

    @PostMapping("/details")
    public ResponseEntity<ResponseModel> getDet(@RequestBody ParamReq paramReq) throws SQLException {

        SaleDetailResponse saleResponse =new SaleDetailResponse();
        ResponseModel responseModel = new ResponseModel<>();
        ResponseEntity<ResponseModel> response;
        Result result = new Result();
        try {
            boolean chk = saleServ.isExsSale(paramReq.getPam());
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

            var ret = saleServ.getDetailInvoice(paramReq.getPam());
            saleResponse.setList(ret);
            responseModel.setData(saleResponse);

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

        SaleHeadResponse saleResponse =new SaleHeadResponse();
        ResponseModel responseModel = new ResponseModel<>();
        ResponseEntity<ResponseModel> response;
        Result result = new Result();
        try {

            var ret = saleServ.getAllInv();
            saleResponse.setList(ret);
            responseModel.setData(saleResponse);

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
