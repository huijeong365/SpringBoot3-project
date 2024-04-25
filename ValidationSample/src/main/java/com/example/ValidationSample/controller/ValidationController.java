package com.example.ValidationSample.controller;

import com.example.ValidationSample.form.CalcForm;
import com.example.ValidationSample.validator.CalcValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ValidationController {
    /* form-backing bean */
    @ModelAttribute
    public CalcForm setUpForm(){
        return new CalcForm();
    }
    /*값을 초기화해서 calcform에 연결해 주는 용도*/

    @GetMapping("show")
    public String showView(){
        return "entry";
    }

    @PostMapping("calc")
    public String confirmView(
            @Validated CalcForm form, BindingResult bindingResult, Model model
    ){
        if(bindingResult.hasErrors()){
            return "entry";
        }
        Integer result = form.getLeftNum() + form.getRightNum();
        model.addAttribute("result",result);

        return "confirm";
    }

    @Autowired
    CalcValidator calcValidator;
    @InitBinder("calcForm")
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators(calcValidator);
    }
}


