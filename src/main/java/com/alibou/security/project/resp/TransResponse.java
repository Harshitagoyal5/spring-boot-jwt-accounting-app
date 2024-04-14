package com.alibou.security.project.resp;

import com.alibou.security.project.entity.views.TransView;
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
public class TransResponse {
    @JsonProperty("translst")
    private List<TransView> list;
}
