package com.example.ValidationSample.form;


import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
/* Model = calcForm (클래스 이름과  model이 자동으로 연결이 됨. 단, 첫글자는 소문자로..)*/
public class CalcForm {
    @NotNull
    @Range(min=1, max=10)
    private Integer leftNum;

    @NotNull
    @Range(min=1, max=10)
    private Integer rightNum;
}
