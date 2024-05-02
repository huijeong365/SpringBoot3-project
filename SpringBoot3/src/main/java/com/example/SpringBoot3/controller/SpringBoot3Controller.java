package com.example.SpringBoot3.controller;

import com.example.SpringBoot3.entity.Board;
import com.example.SpringBoot3.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class SpringBoot3Controller {

   @Autowired
    BoardService service;

    @GetMapping("/board")
    public String showList(Board board, Model model){
        Iterable<Board> list = service.selectAll();

        model.addAttribute("list", list);

        return "board";
    }

    @GetMapping("/board_insert")
    public String insert() {

        return "board_insert";
    }

    @PostMapping("/board_save")
    public String insert_save(Board board) throws Exception {

        service.insertBoard(board);

        return "redirect:/board";
    }

    @GetMapping("/board/{id}")
    public String detail(@PathVariable Integer no, Model model){
        Optional<Board> boardOpt = service.selectOneByNo(no);
        model.addAttribute("boardOpt", boardOpt);

        return "board_detail";
    }

    @PostMapping("/board/update")
    public String update(BindingResult result, Model model, RedirectAttributes redirectAttributes) throws Exception {
       /* Board board = new Board();

        service.updateBoard(board);
        redirectAttributes.addFlashAttribute("complete","변경이 완료 되었습니다");
        return "redirect:/board/" + board.getNo();*/
        return "board";
    }


    @PostMapping("/board/delete")
    public String delete(@RequestParam("no") String no, Model model, RedirectAttributes redirectAttributes) throws Exception {
        service.deleteBoardByNo(Integer.parseInt(no));
        redirectAttributes.addFlashAttribute("delcomplete","삭제 완료했습니다.");

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
