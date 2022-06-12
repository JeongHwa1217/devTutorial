package com.example.demo.controller;

import com.example.demo.dto.PatternRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@Controller
public class PatternController {
    @GetMapping("/pattern")
    @ResponseBody
    public String pattern(PatternRequest input){
        String result = "";
        switch (input.getPtnType()){
            case "ptnA" :
                for (int i=0; i<input.getCount(); i++) {
                    for (int j=0; j<=i; j++) {
                        result += "*";
                    }
                    result += "<br>";
                }
                break;
            case "ptnB" :
                for (int i=0; i<input.getCount(); i++) {
                    for (int j=0; j<input.getCount()-i; j++) {
                        result += "*";
                    }
                    result += "<br>";
                }
                break;
            case "ptnC" :
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
        return result;
    }
}
