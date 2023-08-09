package com.hyunseung.webETA.entity;

import com.hyunseung.webETA.dto.SignUpDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "User")
@Table(name = "User")
@Data
public class UserEntity {
    @Id
    private long userKakaoId;
    private String userKakaoNickname;
    private int userAge;
    private String userFanclub;
    private String userImage;
    public UserEntity(SignUpDto dto){
        this.userKakaoId = dto.getUserKakaoId();
        this.userKakaoNickname = dto.getUserKakaoNickname();
        this.userAge = dto.getUserAge ();
        this.userFanclub = dto.getUserFanclub();
        this.userImage = dto.getUserImage();
    }
}
