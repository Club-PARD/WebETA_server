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
<details markdown = "1">
  <summary>로그인 : api/user/signIn  (POST)</summary>
    <ul>
      <li>Request body</li>
      
```json
{
	"userKakaoId" : "사용자의 카카오 아이디"
	"kakaoAccessToken":"카카오가 발급하는 Token값"
}
```

  <li>Response body </li>  

```json
      {
    "result": true,
    "message": "Sign In Success",
    "data": {
        "token": "JWT 토큰",
        "exprTime": 3600000,
        "user": {
            "userKakaoId": "사용자의 카카오 아이디",
            "userKakaoNickname": "사용자1",
            "userAge": 25,
            "userFanclub": "팬클럽A",
            "userImage": null
        }
    }
}      
```

  </ul>
- 최초 로그인한 유저일 경우 firestore에 정보 저장
### 🔗 Board
- 최근 생성한 질문 2개 
- 질문 생성 시간 순으로 질문 폴더 나열
- 해당 질문 폴더 링크 복사하기
- 종료된 질문 폴더는 아래로 이동


<br>

 

<!-- Stack Icon Refernces -->

[sp]: /readme/spring.png
[ec2]: /readme/EC2.png
[pm]: /readme/postman.png
