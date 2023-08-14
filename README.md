# WebETA_server

<p align="center">
  <br>
  <img src="./readme/Everyfandom.svg">
  <br>
</p>




## ⚙️ 기술 스택

|  Spring    |  AWS_EC2  |  Postman  | 
| :--------: | :-------: | :-------: |
|   ![sp]    |   ![ec2]  |   ![pm]   |

<br>

## 💽 자료구조

### user
    user_kakao_id (PK) (BIGINT)
    user_kakao_nickname (VARCHAR(20))
    user_fanclub (VARCHAR(30))
    user_image (TEXT)

### board
    board_number (PK) (INT) (AUTO_INCREMENT)
    board_title (VARCHAR(255))
    board_description (TEXT)
    board_category (VARCHAR(255))
    board_context (TEXT)
    board_click (BIGINT) (DEFAULT 0)
    board_image (TEXT)
    
    board_writer_id (BIGINT)
    board_writer_nickname (VARCHAR(255))
    board_writer_fanclub (VARCHAR(255))
    
    board_write_date (TIMESTAMP) (DEFAULT CURRENT_TIMESTAMP)

## 📌 주요 기능

###  🔗Auth
- 카카오톡 로그인
- 최초 로그인한 유저일 경우 firestore에 정보 저장
### 🔗 Board
- 최근 생성한 질문 2개 
- 질문 생성 시간 순으로 질문 폴더 나열
- 해당 질문 폴더 링크 복사하기
- 종료된 질문 폴더는 아래로 이동


<br>

 

<!-- Stack Icon Refernces -->

[sp]: /readme/figma.svg
[ec2]: /readme/react.svg
[pm]: /readme/.svg
