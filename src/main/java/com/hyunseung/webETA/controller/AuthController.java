package com.hyunseung.webETA.controller;

import com.hyunseung.webETA.dto.ResponseDto;
import com.hyunseung.webETA.dto.SignInDto;
import com.hyunseung.webETA.dto.SignUpDto;
import com.hyunseung.webETA.dto.SingInResponseDto;
import com.hyunseung.webETA.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class AuthController {
    @Autowired AuthService authService;
    @PostMapping("/signIn")
    public ResponseDto<SingInResponseDto> signIn(@RequestBody SignInDto request){
        ResponseDto<SingInResponseDto> result = authService.signIn(request);
        return result;
    }
    @PostMapping("/signUp")
    public ResponseDto<?> signUp(@RequestBody SignUpDto request){
        ResponseDto<?> result = authService.signUp(request);
        return result;
    }
}
