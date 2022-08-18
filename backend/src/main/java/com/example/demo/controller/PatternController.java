package com.example.demo.controller;

import com.example.demo.Pattern;
import com.example.demo.dto.PatternRequest;
import com.example.demo.service.PatternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class PatternController {
    private PatternService patternService;

    @Autowired
    public PatternController (PatternService patternService){
        this.patternService = patternService;
    }

    @PostMapping("/pattern")
    public String pattern(@RequestBody PatternRequest input){
        return patternService.newPattern(input).getPattern();
    }

    @GetMapping("/patternHistory/{number:.+}")
    public List<Pattern> patternHistory (@PathVariable("number") Integer count){
        return patternService.getHistory(count);
    }
}
