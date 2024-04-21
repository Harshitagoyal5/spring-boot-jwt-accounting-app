package com.alibou.security.project.resp.sale;

import com.alibou.security.project.entity.sale.SaleHead;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaleHeadResponse {
    @JsonProperty("head-sale-lst")
    private List<SaleHead> list;
}
