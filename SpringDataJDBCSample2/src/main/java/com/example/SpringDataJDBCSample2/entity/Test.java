package com.example.SpringDataJDBCSample2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Test {
    //클래스에 부여하는 것으로, 전 필드에 대해 getter/setter롤 엑세스
    //클래스에 부여하는 것으로, 기본 생성자가 자동 생성된다.
    //전 필드에 대해 초기화 값을 인수로 가지는 생성자가 자동 생성
    //기본키 (Primary Key)에 해당하는 id 필드에 대해 @Id 어노테이션 부여

    @Id
    private Integer id;

    private String author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
