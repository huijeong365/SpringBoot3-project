package com.example.SpringBoot3.repository;

import com.example.SpringBoot3.entity.Board;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface BoardRepository extends CrudRepository<Board, Integer> {
    Iterable<Board> findAll(Pageable pageable);
}
