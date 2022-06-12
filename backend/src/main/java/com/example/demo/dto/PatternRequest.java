package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class PatternRequest {
    private String ptnType;
    private Integer count;

}
