package com.hyunseung.webETA.dto;

import com.hyunseung.webETA.entity.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardCreateDto {
    private String boardTitle;
    private String boardDescription;
    private String boardCategory;
    private String boardContext;
    private String boardImage;
    private String boardWriterId;
    private String boardWriterFanclub;
    private String boardWriterNickname;
//    @ManyToOne
//    @JoinColumn(name = "userId")
//    private UserEntity user;
}
