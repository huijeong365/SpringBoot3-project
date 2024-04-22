package com.example.SpringBoot3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringBoot3Controller {
    @GetMapping("index")
    public String showViewA(){

        return "index";
    }
    @GetMapping("board")
    public String showViewB(){

        return "board";
    }
    @GetMapping("qna")
    public String showViewC(){

        return "qna";
    }
    @GetMapping("login")
    public String showViewD(){

        return "login";
    }
}
