package com.alibou.security.project.request;

import com.alibou.security.project.dto.SaleDetailDto;
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
public class SaleRequest {
    @JsonProperty("sale")
    SaleHead invoiceSale;
    @JsonProperty("items")
    List<SaleDetailDto> saleDetails;
}
