package com.board.Service;


import com.board.Repository.BoardRepository;
import com.board.model.Board;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.awt.*;

@Service
public class BoardInfoService {
    //autowired
    private BoardRepository boardRepository;
    private HttpSession session;
    public BoardInfoService(BoardRepository boardRepository,HttpSession session){
        this.boardRepository = boardRepository ;
        this.session = session;
    }

    public String getBoardPost(String stringBoardId){
        Long boardId = Long.parseLong(stringBoardId);
        Board board = boardRepository.findById(boardId).get();

        if(board == null){
            return "board";
        }

        return "boardInfo";
    }



}
