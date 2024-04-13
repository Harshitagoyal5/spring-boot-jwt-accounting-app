package com.alibou.security.payload;
import lombok.Data;
import java.io.Serializable;

@Data
public class Result implements Serializable {
   // boolean status;
    String errMessage;
    int errNo;

//    public boolean isStatus() {
//        return status;
//    }
//
//    public void setStatus(boolean status) {
//        this.status = status;
//    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public int getErrNo() {
        return errNo;
    }

    public void setErrNo(int errNo) {
        this.errNo = errNo;
    }
}

