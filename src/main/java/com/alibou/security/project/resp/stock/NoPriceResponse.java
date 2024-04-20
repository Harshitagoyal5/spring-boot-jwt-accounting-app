package com.alibou.security.project.resp.stock;

import com.alibou.security.project.entity.views.MainStock;
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
public class NoPriceResponse {
    @JsonProperty("price-lst")
    private List<MainStock> list;
}
