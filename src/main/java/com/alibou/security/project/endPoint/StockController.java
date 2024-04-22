package com.alibou.security.project.endPoint;

import com.alibou.security.payload.ResponseModel;
import com.alibou.security.payload.Result;
import com.alibou.security.project.request.TempRequest;
import com.alibou.security.project.request.UpdatePriceRequest;
import com.alibou.security.project.resp.stock.AvaResponse;
import com.alibou.security.project.resp.stock.NoAvaResponse;
import com.alibou.security.project.resp.stock.NoPriceResponse;
import com.alibou.security.project.serv.stock.StockServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1/stock")
public class StockController {


    @Autowired
    StockServ stockServ;

    @PostMapping("/update-item")
    public ResponseEntity<ResponseModel> Update(@RequestBody UpdatePriceRequest request) throws SQLException {
        boolean check= stockServ.isExist(request.getId());
        Result result = new Result();
        ResponseModel re = new ResponseModel();
        ResponseModel responseModel = new ResponseModel<>();
        ResponseEntity<ResponseModel> response;

        if(!check){
            result.setErrNo(2001);
            result.setErrMessage("Not found");
            responseModel.setResult(result);
            responseModel.setData(null);
            response = new ResponseEntity<>(
                    responseModel, HttpStatus.OK
            );
            return response;
        }
       var st= stockServ.UpdatePrice(request.getCost(), request.getPrice(), request.getId());
        re.setData(st.getSale_price());
        result.setErrNo(0);
        result.setErrMessage("Done");
        re.setResult(result);
        return ResponseEntity.ok(re);
    }

    @PostMapping("/available")
    public ResponseEntity<ResponseModel> allAvaItems() throws SQLException {
        AvaResponse avaResponse=new AvaResponse();
        Result result = new Result();
      //  ResponseModel re = new ResponseModel();
        ResponseModel responseModel = new ResponseModel<>();
        ResponseEntity<ResponseModel> response;

        var st= stockServ.getAllItemsAvailable();
        avaResponse.setList(st);


        result.setErrNo(0);
        result.setErrMessage("Done");
        responseModel.setData(avaResponse);
        responseModel.setResult(result);
        return ResponseEntity.ok(responseModel);
    }

    @PostMapping("/no-available")
    public ResponseEntity<ResponseModel> allNoAvaItems() throws SQLException {

        Result result = new Result();
        ResponseModel re = new ResponseModel();
        ResponseModel responseModel = new ResponseModel<>();
        ResponseEntity<ResponseModel> response;
        NoAvaResponse noAvaResponse =new NoAvaResponse();

        var st= stockServ.getAllItemsNonAvailable();
        noAvaResponse.setList(st);

        result.setErrNo(0);
        result.setErrMessage("Done");
        responseModel.setData(noAvaResponse);
        responseModel.setResult(result);
        return ResponseEntity.ok(responseModel);
    }
    @PostMapping("/no-price")
    public ResponseEntity<ResponseModel> allNoPriceItems() throws SQLException {

        Result result = new Result();
        ResponseModel re = new ResponseModel();
        ResponseModel responseModel = new ResponseModel<>();
        ResponseEntity<ResponseModel> response;
        NoPriceResponse noPriceResponse=new NoPriceResponse();

        var st= stockServ.getAllItemsWithNoPrice();
        noPriceResponse.setList(st);
        result.setErrNo(0);
        result.setErrMessage("Done");
        responseModel.setData(noPriceResponse);
        responseModel.setResult(result);
        return ResponseEntity.ok(responseModel);
    }
    @PostMapping("/mv-stock")
    public ResponseEntity<ResponseModel> allMvItems() throws SQLException {

        Result result = new Result();
        ResponseModel re = new ResponseModel();
        ResponseModel responseModel = new ResponseModel<>();
        ResponseEntity<ResponseModel> response;

        var st= stockServ.getAllMovements();
        re.setData(st);
        result.setErrNo(0);
        result.setErrMessage("Done");
        re.setResult(result);
        return ResponseEntity.ok(re);
    }
}
