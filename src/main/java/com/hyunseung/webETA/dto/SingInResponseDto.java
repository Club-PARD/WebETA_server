package com.hyunseung.webETA.dto;

import com.hyunseung.webETA.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SingInResponseDto {
    private String token;
    private int exprTime;
    private UserEntity user;
}
