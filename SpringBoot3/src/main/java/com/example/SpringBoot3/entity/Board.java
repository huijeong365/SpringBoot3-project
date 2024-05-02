package com.example.SpringBoot3.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id
    private Integer no;
    private String title;
    private String author;
    private String contents;
    private int view_count;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate created_date;
}
