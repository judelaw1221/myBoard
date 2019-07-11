package com.board.Service;

import com.board.Repository.BoardRepository;
import com.board.model.Board;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class BoardService {

    @Autowired
    private HttpSession session;
    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }
    //게시판 글 저장 메소드
    public String writeBoard(String boardName,String boardContents,String boardWriter){
        Board board = new Board();
        board.setBoardName(boardName);
        board.setBoardContents(boardContents);
        board.setBoardWriter(boardWriter);

        boardRepository.save(board);
        return "board";
    }

    //게시판 글 수정 메소드
//    public String updateBoard(String boardContents){
//        Board board = new Board();
//        board.setBoardContents(boardContents);
//
//        boardRepository.save(board);
//    }

    //게시판 불러오기 메소드
    public String readBoard(Model model) {

        ArrayList<Board> board = (ArrayList<Board>) boardRepository.findAll();
        session.setAttribute("boardList",board);
        model.addAttribute("alist",board);
        return "board";
        }

}


