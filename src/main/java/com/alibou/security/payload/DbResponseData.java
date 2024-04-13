package com.alibou.security.payload;

import com.alibou.security.project.entity.Accounts;
import com.alibou.security.project.entity.pch.PchTempDetail;
import com.alibou.security.project.resp.pch.PchTempDetailResponse;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class DbResponseData {

    @SerializedName("error")
    private Errors error;
    @SerializedName("templst")
    private List<PchTempDetail> templst;
    @SerializedName("acclst")
    private List<Accounts> acclst;
}
