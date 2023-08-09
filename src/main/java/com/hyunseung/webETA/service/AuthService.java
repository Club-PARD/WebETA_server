package com.hyunseung.webETA.service;

import com.hyunseung.webETA.dto.SignUpDto;
import com.hyunseung.webETA.repository.UserRepository;
import com.hyunseung.webETA.dto.ResponseDto;
import com.hyunseung.webETA.dto.SignInDto;
import com.hyunseung.webETA.dto.SingInResponseDto;
import com.hyunseung.webETA.entity.UserEntity;
import com.hyunseung.webETA.security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    UserRepository userRepository;
    @Autowired TokenProvider tokenProvider;

    public ResponseDto<SingInResponseDto> signIn(SignInDto dto){
        long userKakaoId = dto.getUserKakaoId();
        String kakaoAccessToken = dto.getKakaoAccessToken();
        if (userKakaoId <= 0) {
            return ResponseDto.setFailed("올바르지 않은 kakaoId");
        }
        try{
            Optional<UserEntity> userOptional = userRepository.findById(userKakaoId);
            if (userOptional.isEmpty()) {
                return ResponseDto.setFailed("DB에 저장된 값이 없음");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error");
        }
        UserEntity user=userRepository.findById(userKakaoId).get();
        String token = tokenProvider.create(kakaoAccessToken);
        int exprTime = 3600000;

        SingInResponseDto signInResponseDto = new SingInResponseDto(token, exprTime, user);
        return ResponseDto.setSuccess("Sign In Success", signInResponseDto);
    }

    public ResponseDto<?> signUp(SignUpDto dto){
        long userKakaoId = dto.getUserKakaoId();
        UserEntity user = new UserEntity(dto);
        try {
            if(userKakaoId == 0){
                return ResponseDto.setFailed("userKakaoId notNull");
            }
            if (userRepository.existsById(userKakaoId))
                return ResponseDto.setFailed("Existed Email!");
        } catch (Exception error) {
            error.printStackTrace();
            return ResponseDto.setFailed("Data Base Error!");
        }

        try{
            userRepository.save(user);
        }catch (Exception e){
            return ResponseDto.setFailed("Data Base Error!");
        }

        return ResponseDto.setSuccess("Sign Up Success!", null);
    }
}
