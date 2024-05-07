package com.example.SpringBoot3.controller;

import com.example.SpringBoot3.entity.Board;
import com.example.SpringBoot3.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Optional;

@Controller
public class SpringBoot3Controller {

   @Autowired
    BoardService service;

    @GetMapping("/board")
    public String showList(Board board, Model model, @PageableDefault(sort="no", direction= Sort.Direction.DESC) Pageable pageable ){
        Iterable<Board> list = service.selectAll(pageable);


        model.addAttribute("list", list);

        return "board";
    }

    @GetMapping("/board/insert")
    public String insert() {

        return "board_insert";
    }

    @PostMapping("/board_save")
    public String insert_save(Board board) throws Exception {

        LocalDate localDate = LocalDate.now();
        board.setCreated_date(localDate);

        service.insertBoard(board);

        return "redirect:/board";
    }

    @GetMapping("/board_detail/{no}")
    public String detail(@PathVariable Integer no, Model model) throws Exception{
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

    @PostMapping("/board_updated/{no}")
    public String update(@PathVariable Integer no, Model model, Board board) throws Exception {

        Board board1 = service.selectOneByNo(no);

        board1.setTitle(board.getTitle());
        board1.setContent(board.getContent());
        LocalDate localDate = LocalDate.now();
        board1.setCreated_date(localDate);

        service.updateBoard(board1);

        model.addAttribute("board", board1);

        return "board_detail";
    }


    @PostMapping("/board_delete")
    public String delete(@RequestParam("no") String no) throws Exception {

        service.deleteBoardByNo(Integer.parseInt(no));

        return "redirect:/board";
    }



    @GetMapping("index")
    public String showViewA(){

        return "index";
    }
    @GetMapping("qna")
    public String showViewC(){

        return "qna";
    }
    @GetMapping("login")
    public String showViewD(){

        return "login";
    }
}
