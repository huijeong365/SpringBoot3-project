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
@RequestMapping("/board")
public class SpringBoot3Controller {

   @Autowired
    BoardService service;

    @GetMapping
    public String showList(Board board, Model model){
        Iterable<Board> list = service.selectAll();

        model.addAttribute("list", list);

        return "board";
    }

    @PostMapping("/insert")
    public String insert(BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) throws Exception {
        Board board = new Board();
        board.setTitle(board.getTitle());
        board.setAuthor(board.getAuthor());
        board.setContents(board.getContents());

        service.insertBoard(board);
        redirectAttributes.addFlashAttribute("complete","등록이 완료 되었습니다");
        return "redirect:/board";
    }

    @GetMapping("/{id}")
    public String showUpdate(@PathVariable Integer no, Model model){
        Optional<Board> boardOpt = service.selectOneByNo(no);

        return "board";
    }

    @PostMapping("/update")
    public String update(BindingResult result, Model model, RedirectAttributes redirectAttributes) throws Exception {
        Board board = new Board();

        service.updateBoard(board);
        redirectAttributes.addFlashAttribute("complete","변경이 완료 되었습니다");
        return "redirect:/board/" + board.getNo();

    }


    @PostMapping("/delete")
    public String delete(@RequestParam("no") String no, Model model, RedirectAttributes redirectAttributes) throws Exception {
        service.deleteBoardByNo(Integer.parseInt(no));
        redirectAttributes.addFlashAttribute("delcomplete","삭제 완료했습니다.");

        return "redirect:/board";
    }



    @GetMapping("index")
    public String showViewA(){

        return "index";
    }
    //@GetMapping("board")
    public String showViewB(){

        return "board";
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
