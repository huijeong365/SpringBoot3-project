package com.example.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor /*생성자가없는*/
@AllArgsConstructor
public class Test {
    @Id /*자동생성. getter,setter*/
    private Integer id;
    private String question;
    private Boolean answer;
    private String author;
}
