package com.hyunseung.webETA.repository;

import com.hyunseung.webETA.dto.BoardLoginDto;
import com.hyunseung.webETA.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity,Integer> {
    List<BoardEntity> findByOrderByBoardClickDesc();

    List<BoardEntity> findByBoardWriterFanclubOrderByBoardWriteDateDesc(String fanclub);

    List<BoardEntity> findByBoardWriterId(String id);
}
