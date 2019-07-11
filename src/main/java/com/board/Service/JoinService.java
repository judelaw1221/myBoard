package com.board.Service;

import com.board.Repository.UsersRepository;
import com.board.model.Users;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

        private UsersRepository usersRepository;
        public JoinService(UsersRepository usersRepository){
            this.usersRepository = usersRepository;
        }
        public String joinUser(String userId,String userPw,String userName,String userEmail ){
        Users users = new Users();
        users.setUserId(userId);
        users.setUserPw(userPw);
        users.setUserEmail(userName);
        users.setUserName(userEmail);

        usersRepository.save(users);
        return "index";
        }
}
