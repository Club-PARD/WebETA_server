package com.hyunseung.webETA.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDto {
    @NotBlank
    private long userKakaoId;
    @NotBlank
    private String userKakaoNickname;
    @NotBlank
    private int userAge;
    @NotBlank
    private String userFanclub;
    private String userImage;
}
