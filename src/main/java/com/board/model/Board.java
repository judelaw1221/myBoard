package com.board.model;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Board")
@Getter @Setter
public class Board {
    @Id @GeneratedValue
    private Long boardId;       //게시판글 id
    private String boardName;   //글이름
    private String boardContents;//글내용
    private String boardWriter; //글쓴이

    public String getBoardName() {
        return boardName;
    }

    public void setBoardWriter(String boardWriter) {
        this.boardWriter = boardWriter;
    }

    public String getBoardWriter() {
        return boardWriter;
    }

    public void setBoardContents(String boardContents) {
        this.boardContents = boardContents;
    }

    public String getBoardContents() {
        return boardContents;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }


    public Long getBoardId() {
        return boardId;
    }
    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }
}
