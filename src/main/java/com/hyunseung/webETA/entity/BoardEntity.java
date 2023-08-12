package com.hyunseung.webETA.entity;

import com.hyunseung.webETA.dto.BoardCreateDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Board")
@Table(name = "Board")
@Data
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardNumber;
    private String boardTitle;
    private String boardDescription;
    private String boardCategory;
    private String boardContext;
    @ColumnDefault("0")
    private long boardClick;
    private String boardImage;
    private String boardWriterId;
    private String boardWriterNickname;
    private String boardWriterFanclub;
//    @ManyToOne
//    @JoinColumn(name = "userId")
//    private UserEntity user;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp boardWriteDate;

    public BoardEntity(BoardCreateDto dto) {
        this.boardTitle = dto.getBoardTitle();
        this.boardDescription = dto.getBoardDescription();
        this.boardCategory = dto.getBoardCategory();
        this.boardContext = dto.getBoardContext();
        this.boardImage = dto.getBoardImage();
        this.boardWriterId = dto.getBoardWriterId();
        this.boardWriterFanclub = dto.getBoardWriterFanclub();
        this.boardWriterNickname = dto.getBoardWriterNickname();

    }
}
