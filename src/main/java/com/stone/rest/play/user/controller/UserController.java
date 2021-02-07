package com.stone.rest.play.user.controller;

import com.stone.rest.play.common.exception.AuthenticationFailedException;
import com.stone.rest.play.common.exception.EmailDuplicationException;
import com.stone.rest.play.user.payload.UserReq;
import com.stone.rest.play.user.payload.UserReq.RegisterDto;
import com.stone.rest.play.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class UserController {

    private final UserService userService;

    /**
     * 가입
     *
     * @param registerDto
     * @return
     * @throws EmailDuplicationException
     */
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterDto registerDto) throws EmailDuplicationException {
        return new ResponseEntity<>(userService.registerUser(registerDto), HttpStatus.CREATED);
    }

    /**
     * 로그인
     *
     * @param loginDto
     * @return
     * @throws AuthenticationFailedException
     */
    @PostMapping("/login")
    public void loginUser(@Valid @RequestBody UserReq.LoginDto loginDto) throws AuthenticationFailedException {
        log.info("=====================LOGIN=============================");
        log.info("=====================LOGIN=============================");
    }
//    public ResponseEntity<?> loginUser(@Valid @RequestBody UserReq.LoginDto loginDto) throws AuthenticationFailedException {
//        return new ResponseEntity<>(userService.loginUser(loginDto), HttpStatus.OK);
//    }

}

