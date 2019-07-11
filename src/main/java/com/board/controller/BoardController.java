package com.board.controller;


import com.board.Service.BoardInfoService;
import com.board.Service.BoardService;
import com.board.model.Board;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class BoardController {
    private BoardService boardService;
    private BoardInfoService boardInfoService;
    public BoardController(BoardService boardService,BoardInfoService boardInfoService){
        this.boardService = boardService;
        this.boardInfoService = boardInfoService;
    }

    @GetMapping("/board")
//    public String board(Map<String, Object> param,Model model){
//        boardService.readBoard(model);
//
//        return "board";
//    }
    public String board(Model model){
         boardService.readBoard(model);
        return "board"; }


    @GetMapping("/write")
        public String write(){
        return "write";
        }

    @GetMapping("/writereq")
        public String writeReq(@RequestParam Map<String, Object> param){
        String name = (String) param.get("boardName");
        String contents = (String) param.get("boardContents");
        String writer = (String) param.get("writer");

        boardService.writeBoard(name,contents,writer);

        return "redirect:/board";
    }
    @GetMapping("boardInfo")
    public String getPost(@RequestParam(value="boardId") String boardId){
        String page = boardInfoService.getBoardPost(boardId);
        return page;
    }



}
