package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping
    public String index(){
        // Sprint Web의 Model을 사용해서, ViewResolver가 index.html파일 찾아 반환
        // Thymeleaf 사용시 default가 templates/ 폴더여서 resources/templates/index.html 경로를 찾음
        return "index";
    }
}
