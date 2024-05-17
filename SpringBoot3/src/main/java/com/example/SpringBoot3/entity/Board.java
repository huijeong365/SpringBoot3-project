package com.example.SpringBoot3.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "board")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id
    @Column(name="no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer no;
    private String title;
    private String author;
    private String content;
    private int view_count;

    public Board updateViewCount(Integer view_count){
        this.view_count = view_count+1;
        return this;
    }
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate created_date;
}
