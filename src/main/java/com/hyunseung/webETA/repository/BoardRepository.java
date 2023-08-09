package com.hyunseung.webETA.repository;

import com.hyunseung.webETA.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity,Integer> {
}
