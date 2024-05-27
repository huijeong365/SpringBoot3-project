package com.example.SpringBoot3.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    private String title;

    /*@NotBlank
    private String author;*/
    @NotNull
    private String content;

    @NotNull
    private int view_count;

    public Board updateViewCount(Integer view_count){
        this.view_count = view_count+1;
        return this;
    }

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate created_date;


    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

}
