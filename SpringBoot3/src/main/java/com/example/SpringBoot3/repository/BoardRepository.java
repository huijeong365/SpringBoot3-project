package com.example.SpringBoot3.repository;

import com.example.SpringBoot3.entity.Board;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;


public interface BoardRepository extends CrudRepository<Board, Integer> {
    @Query("SELECT * FROM board WHERE no ORDER BY no DESC")
    Integer getNo();

}
