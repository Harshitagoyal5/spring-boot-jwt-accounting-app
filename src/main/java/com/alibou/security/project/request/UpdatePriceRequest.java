package com.alibou.security.project.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePriceRequest {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("cost")
    private Double cost;
    @JsonProperty("sale_price")
    private Double price;
}
