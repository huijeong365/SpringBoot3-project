package com.example.SpringBoot3.service;

import com.example.SpringBoot3.entity.Board;
import com.example.SpringBoot3.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository repository;

    @Override
    public Page<Board> boardSearchList(String searchKeyword, Pageable pageable){
        return repository.findByTitleContaining(searchKeyword,pageable);
    }

    @Override
    public Page<Board> selectAll(Pageable pageable) {

        return repository.findAll(pageable);
    }

    @Override
    public Board selectOneByNo(int no) {

        Board board = repository.findById(no).get();

        return board;
    }

    @Override
    public void insertBoard(Board board){

        repository.save(board);

    }

    @Override
    public void updateBoard(Board board) {

        repository.save(board);

    }

    @Override
    public void deleteBoardByNo(int no){
        repository.deleteById(no);
    }
}
