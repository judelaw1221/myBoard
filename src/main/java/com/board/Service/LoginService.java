package com.board.Service;


import com.board.Repository.UsersRepository;
import com.board.model.Users;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LoginService {

    private UsersRepository usersRepository;
    private PasswordEncrypt passwordEncrypt;
    private HttpSession session;
    public LoginService(UsersRepository usersRepository,PasswordEncrypt passwordEncrypt,HttpSession httpSession) {
        this.usersRepository = usersRepository;
        this.passwordEncrypt = passwordEncrypt;
        this.session = httpSession;
    }
     public String loginUsers(String id, String pw){
        String shaPw = passwordEncrypt.getSHA256(pw);
        Users users = usersRepository.findFirstByUserIdAndUserPw(id,shaPw);

        if( users == null ){
            return "index";
        }

        session.setAttribute("loginUser",users);
        return "index";
     }
}
