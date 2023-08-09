package com.hyunseung.webETA.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Board")
@Table(name = "Board")
@Data
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardNum;
    private String boardTitle;
    private String boardDescription;
    private String boardCategory;
    private String boardContext;
    private long boardClick;
    private String boardImage;
    private String boardWriterId;
    private String boardWriterNickname;
    private String boardWriterFanclub;
    private Timestamp boardWriteDate;
}
