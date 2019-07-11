package com.board.controller;

import com.board.Service.JoinService;
import com.board.Service.LoginService;
import com.board.Service.PasswordEncrypt;
import com.board.model.Users;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
@Controller
public class UsersController {

    private JoinService joinService;
    private LoginService loginService;
    private PasswordEncrypt passwordEncrypt;
    public UsersController (JoinService joinService
                            ,LoginService loginService
                            ,PasswordEncrypt passwordEncrypt){
        this.joinService = joinService;
        this.loginService = loginService;
        this.passwordEncrypt = passwordEncrypt;
    }

    @PostMapping("/joinuser")
    public String joinUser(@RequestParam Map<String, Object> param) {
        System.out.println("입력");
        String id = (String) param.get("user_id");
        String pw =(String) param.get("user_pw");
        String name = (String) param.get("user_name");
        String email = (String) param.get("user_email");

        System.out.println("입력");
        String shaPw = passwordEncrypt.getSHA256(pw);
        String page = joinService.joinUser(id,shaPw,name,email);
        return page;
    }

    @PostMapping("/login")
    public String login(@RequestParam Map<String, Object> param){
        String id=(String)param.get("user_id");
        String pw = (String)param.get("user_pw");
        String page = loginService.loginUsers(id,pw);

        return page;
    }
}
