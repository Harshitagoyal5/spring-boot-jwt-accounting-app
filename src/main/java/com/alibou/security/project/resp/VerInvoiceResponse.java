package com.alibou.security.project.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VerInvoiceResponse {
    @JsonProperty("id")
 private Long id;
    @JsonProperty("total")
 private double total;
    @JsonProperty("discount")
 private double discount;
    @JsonProperty("created_at")
 private String cr;
    @JsonProperty("vendor_id")
    private int vendorId;
    @JsonProperty("temp")
    private Long temp;
}
