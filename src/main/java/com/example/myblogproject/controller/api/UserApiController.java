package com.example.myblogproject.controller.api;

import com.example.myblogproject.dto.ResponseDto;
import com.example.myblogproject.model.RoleType;
import com.example.myblogproject.model.User;
import com.example.myblogproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;


    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> save(@RequestBody User user){
        System.out.println("UserApiController : save 호출됨");
        //실제로 DB에 insert하고 아래에서 return이 되면 된다.
        //자바오브젝트를 JSON으로 변환해서 리턴(Jackson)
        userService.회원가입(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
