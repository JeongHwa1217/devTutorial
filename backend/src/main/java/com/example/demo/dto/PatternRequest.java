package com.example.demo.dto;

import com.example.demo.type.PatternType;
import lombok.Data;

@Data
public class PatternRequest {

    private String ptnType;
    private Integer count;

}
