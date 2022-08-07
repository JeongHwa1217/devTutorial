package com.example.demo;

import com.example.demo.type.PatternType;
import lombok.Data;

@Data
public class Pattern {
    private PatternType type;
    private Integer count;
    private String pattern;
}
