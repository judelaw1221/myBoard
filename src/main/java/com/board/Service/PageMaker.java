package com.board.Service;


import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
@Getter
public class PageMaker {
   private int totalcnt;    //전체게시물수
   private int pagenum;     //전체헤이지번호
   private int contentnum;  //
   private int startPage;
   private int endPage;
   private boolean prev;
   private boolean next;
   private int currentblock;
   private int lastblock;

   //전체페이지수
   public int calpage (int totalcnt,int contentnum){
       int totalpage = totalcnt / contentnum;
       if (totalcnt%contentnum>0){
           totalcnt ++;
       }
       return totalpage;
   }

   public void setStartPage(int currentblock){
       this.startPage = (currentblock*5)-4;
   }
   public void setEndPage(int currentblock){
       this.endPage = (currentblock*5);
   }
}
