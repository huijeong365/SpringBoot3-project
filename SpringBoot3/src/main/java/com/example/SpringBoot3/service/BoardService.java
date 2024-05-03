package com.example.SpringBoot3.service;

import com.example.SpringBoot3.entity.Board;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BoardService {
    Iterable<Board> selectAll(Pageable pageable);
    /*board의 모든 데이터를 가져옴*/
    Board selectOneByNo(int no);
    /*no값으로 데이터를 불러옴*/
    void insertBoard (Board board) throws Exception;
    /*새 데이터 작성*/
    void updateBoard (Board board) throws Exception;
    /*데이터 수정*/
    void deleteBoardByNo(int no) throws Exception;
    /*데이터 삭제*/
}
