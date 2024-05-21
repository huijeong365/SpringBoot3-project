package com.example.SpringBoot3.controller;

import com.example.SpringBoot3.entity.Board;
import com.example.SpringBoot3.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class BoardController {

   @Autowired
    BoardService service;

    @GetMapping("/board")
    public String showList(Board board, Model model, @PageableDefault(sort="no", direction= Sort.Direction.DESC) Pageable pageable, String searchKeyword ){

        Page<Board> list = null;

        if (searchKeyword == null) {
            // 검색 단어가 없으면 기존 화면을 보여준다.
            list = service.selectAll(pageable);
        } else {
            // 검색 단어가 들어오면 검색 단어에 맞게 나온다. 쿼리스트링으로 들어가는 키워드를 찾아냄
            list = service.boardSearchList(searchKeyword, pageable);
        }

        model.addAttribute("list", list);

        return "board";
    }

    @GetMapping("/board/insert")
    public String insert() {

        return "board_insert";
    }

    @GetMapping("/board_save")
    public String insert_save(Board board, BindingResult bindingResult, Model model){

        LocalDate localDate = LocalDate.now();
        board.setCreated_date(localDate);

 /*       service.insertBoard(board);

        return "redirect:/board";*/

        if (!bindingResult.hasErrors()) {
            service.insertBoard(board);
            return "redirect:/board";
        }else {
            model.addAttribute("msg", "글 작성을 완료해 주세요");
            return "/board_insert";
        }

    }

    @GetMapping("/board_detail/{no}")
    public String detail(@PathVariable Integer no, Model model){
        Board board = service.selectOneByNo(no);
        board.updateViewCount(board.getView_count());
        service.updateBoard(board);
        model.addAttribute("board", board);

        return "board_detail";
    }

    @GetMapping("/board_update/{no}")
    public String updateForm(@PathVariable Integer no, Model model) {
        Board board = service.selectOneByNo(no);

        model.addAttribute("board", board);

        return "board_update";
    }

    @GetMapping("/board_updated/{no}")
    public String update(@PathVariable Integer no, Model model, Board board){

        Board board1 = service.selectOneByNo(no);

        board1.setTitle(board.getTitle());
        board1.setContent(board.getContent());
        LocalDate localDate = LocalDate.now();
        board1.setCreated_date(localDate);

        service.updateBoard(board1);

        model.addAttribute("board", board1);

        return "board_detail";
    }


    @GetMapping("/board_delete")
    public String delete(@RequestParam("no") String no){

        service.deleteBoardByNo(Integer.parseInt(no));

        return "redirect:/board";
    }

    @GetMapping("/index")
    public String showViewA(){

        return "index";
    }
    @GetMapping("/qna")
    public String showViewC(){

        return "qna";
    }


}
