package com.example.demo.service;

import com.example.demo.Pattern;
import com.example.demo.dto.PatternRequest;
import com.example.demo.type.PatternType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatternService {
    private List<Pattern> patternList= new ArrayList<>();
    private int seq = 0;

    public Pattern newPattern(PatternRequest input){
        Pattern pattern = new Pattern();
        String result = "";
        switch (input.getPtnType()){
            case "ptnA" :
                pattern.setType(PatternType.PATTERN_A);
                for (int i=0; i<input.getCount(); i++) {
                    for (int j=0; j<=i; j++) {
                        result += "*";
                    }
                    result += "<br>";
                }
                break;
            case "ptnB" :
                pattern.setType(PatternType.PATTERN_B);
                for (int i=0; i<input.getCount(); i++) {
                    for (int j=0; j<input.getCount()-i; j++) {
                        result += "*";
                    }
                    result += "<br>";
                }
                break;
            case "ptnC" :
                pattern.setType(PatternType.PATTERN_C);
                int quo = input.getCount()/2;
                for (int i=0; i<quo; i++) {
                    for (int j=0; j<2*i+1; j++) {
                        result += "*";
                    }
                    result += "<br>";
                }
                for (int i=quo; i>=0; i--) {
                    for (int j=0; j<2*i+1; j++) {
                        result += "*";
                    }
                    result += "<br>";
                }
                break;
            case "ptnD":
                pattern.setType(PatternType.PATTERN_D);
                for (int i=input.getCount(); i>0; i--){
                    for(int j=0; j<i-1; j++){
                        result += "&nbsp;";
                    }
                    for(int j=0; j< input.getCount(); j++){
                        result += "*";
                    }
                    result += "<br>";
                }
                break;
            case "ptnE":
                pattern.setType(PatternType.PATTERN_E);
                for (int i=input.getCount(); i>0; i--){
                    for(int j=0; j<i-1; j++){
                        result += "&nbsp;";
                    }
                    for(int j=0; j<i; j++){
                        result += "*";
                    }
                    result += "<br>";
                }
                break;
        }
        pattern.setCount(input.getCount());
        pattern.setPattern(result);
        savePattern(pattern);
        return pattern;
    }

    public Integer savePattern(Pattern pattern){
        ++seq;
        this.patternList.add(pattern);
        return seq;
    }

    public List<Pattern> getHistory (Integer count){
        if(seq < 1){
            return null;
        }
        if(count >= seq){
            return patternList.subList(0, seq);
        }
        return patternList.subList(seq-count, seq);
    }
}
