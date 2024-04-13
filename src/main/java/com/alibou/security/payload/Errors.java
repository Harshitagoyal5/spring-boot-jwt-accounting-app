package com.alibou.security.payload;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Errors {
    @SerializedName("errNo")
    private String errNo;

}
