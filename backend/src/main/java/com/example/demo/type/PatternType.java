package com.example.demo.type;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum PatternType{
    PATTERN_A("ptnA"),
    PATTERN_B("ptnB"),
    PATTERN_C("ptnC"),
    PATTERN_D("ptnD"),
    PATTERN_E("ptnE"),
    ;

    private final String type;

    PatternType(String type) {
        this.type = type;
    }

    @JsonCreator
    public static PatternType from(String type){
        return PatternType.valueOf(type);
    }
}
