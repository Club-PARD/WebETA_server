package com.hyunseung.webETA.service;

import com.hyunseung.webETA.dto.BoardCreateDto;
import com.hyunseung.webETA.dto.BoardLoginDto;
import com.hyunseung.webETA.dto.ResponseDto;
import com.hyunseung.webETA.entity.BoardEntity;
import com.hyunseung.webETA.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public ResponseDto<?>createBoard(BoardCreateDto dto){
        BoardEntity boardEntity = new BoardEntity(dto);
        try{
            boardRepository.save(boardEntity);
            return ResponseDto.setSuccess("Board Create Success", null);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error");
        }
    }
    public ResponseDto<List<BoardEntity>> getList(String id){
        List<BoardEntity> boardList;
        try {
            Sort sort = Sort.by(Sort.Direction.DESC, "boardWriteDate"); //ASC 는 오름차순
            boardList = boardRepository.findByBoardWriterId(id);
            return ResponseDto.setSuccess("Read Success!", boardList);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB error");
        }
    }

    public ResponseDto<?> deleteBoard(Integer id){
        try{
            boardRepository.deleteById(id);
            return ResponseDto.setSuccess("Board Delete Success!",null);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error");
        }
    }
    public ResponseDto<List<BoardEntity>> getAllList(){
        List<BoardEntity> boardList;
        try{
            boardList = boardRepository.findByOrderByBoardClickDesc();
            return ResponseDto.setSuccess("성공", boardList);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error");
        }
    }
    @Transactional
    public ResponseDto<BoardEntity> getOneList(Integer id){
        BoardEntity boardList;
        try{
            Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(id);

            if (optionalBoardEntity.isPresent()) {
                boardList = optionalBoardEntity.get();
                boardList.setBoardClick(boardList.getBoardClick() + 1);
                return ResponseDto.setSuccess("Read One List", boardList);
            } else {
                return ResponseDto.setFailed("Board not found");
            }        }catch(Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error");
        }
    }
    @Transactional
    public ResponseDto<?> updateBoard(Integer id, BoardCreateDto dto){
        BoardEntity boardEntity = boardRepository.findById(id).get();
        try {
            if(dto.getBoardWriterId().equals(boardEntity.getBoardWriterId())) {
                if (dto.getBoardTitle() != null && !dto.getBoardTitle().isEmpty()) boardEntity.setBoardTitle(dto.getBoardTitle());
                if (dto.getBoardDescription() != null && !dto.getBoardDescription().isEmpty()) boardEntity.setBoardDescription(dto.getBoardDescription());
                if (dto.getBoardCategory() != null && !dto.getBoardCategory().isEmpty()) boardEntity.setBoardCategory(dto.getBoardCategory());
                if (dto.getBoardImage() != null && !dto.getBoardImage().isEmpty()) boardEntity.setBoardImage(dto.getBoardImage());
                System.out.println("boardEntity.getBoardWriterId(): " + boardEntity.getBoardWriterId());
                System.out.println("dto.getBoardWriterId(): " + dto.getBoardWriterId());
                return ResponseDto.setSuccess("Board update Success",null);
            }else {
                System.out.println("boardEntity.getBoardWriterId(): " + boardEntity.getBoardWriterId());
                System.out.println("dto.getBoardWriterId(): " + dto.getBoardWriterId());
                return ResponseDto.setFailed("Id가 같지 않음");
            }

        }catch (Exception e){
            return ResponseDto.setFailed("DB Error");
        }
    }
    public ResponseDto<List<BoardEntity>> getLoginList(String fanclub){
        List<BoardEntity> boardList;
        try{
            boardList = boardRepository.findByBoardWriterFanclubOrderByBoardWriteDateDesc(fanclub);
            return ResponseDto.setSuccess("조회수로 배열",boardList);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error");
        }
    }
}
