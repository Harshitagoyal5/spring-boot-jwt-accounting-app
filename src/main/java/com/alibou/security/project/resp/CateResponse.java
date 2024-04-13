package com.alibou.security.project.resp;

import com.alibou.security.project.entity.Cate;
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
public class CateResponse {
//        @JsonProperty("cate")
//        private Cate one;
    @JsonProperty("catelst")
    private List<Cate> cates;

}
