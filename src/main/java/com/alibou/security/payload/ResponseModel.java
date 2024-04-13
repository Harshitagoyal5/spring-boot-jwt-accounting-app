package com.alibou.security.payload;
import lombok.Data;
@Data
public class ResponseModel<T> {
    private T data;

    private Result result;

}
