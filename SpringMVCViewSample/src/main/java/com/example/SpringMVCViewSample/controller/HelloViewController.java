package com.example.SpringMVCViewSample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //생성자
@RequestMapping("hello") //컨트롤러의 요청("hello")이 들어오면 실행해라!
//@RequestMapping( value = "hello" )
//@RequestMapping("hello")
//@RequestMapping( value = { "hello", "hellospring" })
//@RequestMapping( value = { "hello", method = RequestMapping.GET })  데이터 전달방식을 지정할 수 있다.
//@RequestMapping( value = { "hello", method = RequestMapping.GET, RequestMapping.POST })
public class HelloViewController {

    //@GetMapping("view")
    public String helloView(){
        return "hello"; //hello 라는 jsp를 실행한다.
    }

    //문제) http://localhost:8080/hello/view2를 입력하면 morning가 출력되게 만들어 보세요.
    //@GetMapping("view2")
    public String helloView2(){
        return "morning";
    }

    //문제) http://localhost:8080/hello/view2 또는 view를 입력하면 Hello View!!가 출력되게 만들어 보세요.
    @GetMapping( value = { "view", "view2"})
    public String helloView3(){
        return "hello";
    }
}



