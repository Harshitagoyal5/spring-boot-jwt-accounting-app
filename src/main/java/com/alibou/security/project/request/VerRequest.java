package com.alibou.security.project.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VerRequest implements Serializable {
    @JsonProperty("temp_id")
    private Long id;
    @JsonProperty("discount")
    private double discount;
    @JsonProperty("total")
    private double total;
}
