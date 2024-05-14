package com.example.SpringBoot3.service;

import com.example.SpringBoot3.entity.Board;
import com.example.SpringBoot3.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    @Autowired(required = false)
    BoardRepository repository;

    @Override
    public Iterable<Board> selectAll(Pageable pageable) {

        return repository.findAll(pageable);
    }

    @Override
    public Board selectOneByNo(int no) {

        Board board = repository.findById(no).get();

        return board;
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
