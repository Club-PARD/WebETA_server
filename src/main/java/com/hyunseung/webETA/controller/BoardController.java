package com.hyunseung.webETA.controller;

import com.hyunseung.webETA.dto.BoardCreateDto;
import com.hyunseung.webETA.dto.ResponseDto;
import com.hyunseung.webETA.entity.BoardEntity;
import com.hyunseung.webETA.repository.BoardRepository;
import com.hyunseung.webETA.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
public class BoardController {
    private final BoardService boardService;
    @Autowired
    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @PostMapping("/create")
    public ResponseDto<?>boardCreate(@RequestBody BoardCreateDto requestBody){
        ResponseDto<?> result = boardService.createBoard(requestBody);
        return result;
    }
    @GetMapping("/allList")
    public ResponseDto<List<BoardEntity>> getAllList(){
        return boardService.getAllList();
    }
    @GetMapping("/oneList/{id}")
    public ResponseDto<BoardEntity> getOneList(@PathVariable("id") Integer id){
        return boardService.getOneList(id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseDto<?> deleteBoard(@PathVariable("id") Integer id){
        return boardService.deleteBoard(id);
    }

    @PutMapping("/update/{id}")
    public ResponseDto<?> updateBoard(@PathVariable("id") Integer id, @RequestBody BoardCreateDto requestBody){
        return boardService.updateBoard(id, requestBody);
    }
    @GetMapping("/loginList")
    public ResponseDto<List<BoardEntity>>getLoginList(){
        return boardService.getLoginList();
    }

}
