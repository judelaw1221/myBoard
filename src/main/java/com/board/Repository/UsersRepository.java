package com.board.Repository;

import com.board.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
    Users findFirstByUserIdAndUserPw(String user_id,String user_pw);
}
