package com.example.SpringBoot3.service;

import com.example.SpringBoot3.entity.Board;
import com.example.SpringBoot3.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
@Transactional
public class BoardServiceImpl implements BoardService{

    @Autowired
    BoardRepository repository;

    @Override
    public Iterable<Board> selectAll(Pageable pageable) {

        return repository.findAll(pageable);
    }

    @Override
    public Board selectOneByNo(int no) {

        return repository.findById(no).get();
    }

    @Override
    public void insertBoard(Board board) throws Exception {

        repository.save(board);

    }

    @Override
    public void updateBoard(Board board) throws Exception {

        repository.save(board);

    }

    @Override
    public void deleteBoardByNo(int no) throws Exception {
        repository.deleteById(no);
    }
}
