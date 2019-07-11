package com.board.controller;
import com.board.Service.JoinService;
import com.board.Service.LoginService;
import com. board.model.Users;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.mapping.Join;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.naming.event.ObjectChangeListener;
import java.util.Map;


@Slf4j
@Controller
public class MainController {


   @GetMapping ("/")
   public String index(){
       return "index";
   }
   @GetMapping("/join")
   public String join(){
        return "joinuser";
   }
   @GetMapping("/login")
   public String login(){ return "login"; }



}