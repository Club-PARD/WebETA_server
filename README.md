# WebETA_server

<p align="center">
  <br>
  <img src="./readme/Everyfandom.svg">
  <br>
</p>

<h3 align = "center"> 4050 중장년을 위한 아이돌 덕질 플랫폼 </h3>




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
 </details>
  
 <details markdown = "1">
  <summary>회원가입 : api/user/signUp  (POST)</summary>
    <ul>
      <li>Request body</li>
      
```json
{
    "userKakaoId" : "201806142",
    "userKakaoNickname" : "김현승",
    "userFanclub":"세븐틴",
    "userImage" : "이미지"
}
```

  <li>Response body </li>  

```json
{
    "result": true,
    "message": "Sign Up Success!",
    "data": null
}    
```

  </ul>
 </details>

### 🔗 Board

 <details markdown = "1">
  <summary>보드 생성 : api/board/create (POST)</summary>
    <ul>
      <li>Header</li>
      
```json
{
	"Header" : {
		"Authoriztion" : "Bearer " + localstorge.getItem(token),
		"Content-Type" : "application/json" 
			}
}
```

  <li>Request Body </li>  

```json
{
    "boardTitle": "실험 제목",
    "boardDescription": "새롭게2 설명",
    "boardCategory": "새로운2 카테고리",
    "boardImage": "새롭게 이미지 URL",
    "boardWriterId": "1234",
    "boardWriterFanclub" : "세븐틴",
    "boardWriterNickname": "게시물 작성자 닉네임"
}
```

  <li>Response body</li>  

```json
{
    "result": true,
    "message": "Board Create Success",
    "data": null
}
```

  </ul>
 </details>


 <details markdown = "1">
  <summary >보드 전체 읽기(로그인 전) : api/board/allList(GET)</summary>
    <ul>

  <li>Response Body </li>  

```json
{
    "result": true,
    "message": "성공",
    "data": [
        {
            "boardNumber": 6,
            "boardTitle": "이미지제목",
            "boardDescription": "업데이트 설명",
            "boardCategory": "업데이트 카테고리",
            "boardContext": "url",
            "boardClick": 4,
            "boardImage": "z",
            "boardWriterId": "1234",
            "boardWriterNickname": "게시물 작성자 닉네임",
            "boardWriterFanclub": "세븐틴",
            "boardWriteDate": "2023-08-12T06:50:54.000+00:00"
        },
        {
            "boardNumber": 4,
            "boardTitle": "새로운2 제목",
            "boardDescription": "새롭게2 설명",
            "boardCategory": "새로운2 url",
            "boardContext": "새로운2 내용",
            "boardClick": 0,
            "boardImage": "z",
            "boardWriterId": "1234",
            "boardWriterNickname": "게시물 작성자 닉네임",
            "boardWriterFanclub": "세븐틴",
            "boardWriteDate": "2023-08-12T04:58:16.000+00:00"
        },
        {
            "boardNumber": 5,
            "boardTitle": "실험 제목",
            "boardDescription": "새롭게2 설명",
            "boardCategory": "새로운2 url",
            "boardContext": "새로운2 내용",
            "boardClick": 0,
            "boardImage": "새롭게 이미지 URL",
            "boardWriterId": "1234",
            "boardWriterNickname": "게시물 작성자 닉네임",
            "boardWriterFanclub": "세븐틴",
            "boardWriteDate": "2023-08-12T04:55:48.000+00:00"
        }
    ]
}
```

  </ul>
 </details>

 <details markdown = "1">
  <summary>보드 하나 읽기 :api/board/oneList/{id}(GET)</summary>
    <ul>
      <li>Header</li>
      
```json
{
	"Header" : {
		"Authoriztion" : "Bearer " + localstorge.getItem(token),
		"Content-Type" : "application/json" 
			}
}
```

  <li>PathVariable </li>  

```json
{
	"id" : "boardNumber"
}
```

  <li>Response body</li>  

```json
{
    "result": true,
    "message": "Read One List",
    "data": {
        "boardNumber": 3,
        "boardTitle": "새로운 제목",
        "boardDescription": "새롭게 설명",
        "boardCategory": "새로운 url",
        "boardContext": "새로운 내용",
        "boardClick": 6,
        "boardImage": "새롭게 이미지 URL",
        "boardWriterId": "1234",
        "boardWriterNickname": "게시물 작성자 닉네임",
        "boardWriterFanclub": "세븐틴",
        "boardWriteDate": "2023-08-12T04:40:00.000+00:00"
    }
}
```

  </ul>
 </details>
 
 <details markdown = "1">
  <summary>보드 삭제 : api/board/delete/{id}(DELETE)</summary>
    <ul>
      <li>Header</li>
      
```json
{
	"Header" : {
		"Authoriztion" : "Bearer " + localstorge.getItem(token),
		"Content-Type" : "application/json" 
			}
}
```

  <li>PathVariable </li>  

```json
{
	"id" : "dataNoticeId"
}
```

  <li>Response body</li>  

```json
{
    "result": true,
    "message": "Board Delete Success!",
    "data": null
}
```

  </ul>
 </details>


 <details markdown = "1">
  <summary>보드 전체 읽기(로그인 후) : api/board/allList(GET)</summary>
    <ul>
      <li>Header</li>
      
```json
{
	"Header" : {
		"Authoriztion" : "Bearer " + localstorge.getItem(token),
		"Content-Type" : "application/json" 
			}
}
```
  <li>Request Body </li>  

```json
{
	"userFanclub":"세븐틴"    
}
```

  <li>Response body</li>  

```json
{
    "result": true,
    "message": "조회수로 배열",
    "data": [
        {
            "boardNumber": 3,
            "boardTitle": "새로운 제목",
            "boardDescription": "새롭게 설명",
            "boardCategory": "새로운 카테고리",
            "boardContext": "새로운 url",
            "boardClick": 6,
            "boardImage": "새롭게 이미지 URL",
            "boardWriterId": "1234",
            "boardWriterNickname": "게시물 작성자 닉네임",
            "boardWriterFanclub": "세븐틴",
            "boardWriteDate": "2023-08-12T04:40:00.000+00:00"
        },
        {
            "boardNumber": 6,
            "boardTitle": "이미지제목",
            "boardDescription": "업데이트 설명",
            "boardCategory": "업데이트 카테고리",
            "boardContext": "url",
            "boardClick": 4,
            "boardImage": "z",
            "boardWriterId": "1234",
            "boardWriterNickname": "게시물 작성자 닉네임",
            "boardWriterFanclub": "세븐틴",
            "boardWriteDate": "2023-08-12T06:50:54.000+00:00"
        },
        {
            "boardNumber": 7,
            "boardTitle": "실험 제목",
            "boardDescription": "새롭게2 설명",
            "boardCategory": "새로운2 카테고리",
            "boardContext": "새로운2 내용",
            "boardClick": 1,
            "boardImage": "새롭게 이미지 URL",
            "boardWriterId": "1234",
            "boardWriterNickname": "게시물 작성자 닉네임",
            "boardWriterFanclub": "세븐틴",
            "boardWriteDate": "2023-08-12T06:03:49.000+00:00"
        },
        {
            "boardNumber": 4,
            "boardTitle": "새로운2 제목",
            "boardDescription": "새롭게2 설명",
            "boardCategory": "새로운2 카테고리",
            "boardContext": "새로운2 내용",
            "boardClick": 0,
            "boardImage": "z",
            "boardWriterId": "1234",
            "boardWriterNickname": "게시물 작성자 닉네임",
            "boardWriterFanclub": "세븐틴",
            "boardWriteDate": "2023-08-12T04:58:16.000+00:00"
        },
        {
            "boardNumber": 5,
            "boardTitle": "실험 제목",
            "boardDescription": "새롭게2 설명",
            "boardCategory": "새로운2 카테고리",
            "boardContext": "새로운2 내용",
            "boardClick": 0,
            "boardImage": "새롭게 이미지 URL",
            "boardWriterId": "1234",
            "boardWriterNickname": "게시물 작성자 닉네임",
            "boardWriterFanclub": "세틴",
            "boardWriteDate": "2023-08-12T04:55:48.000+00:00"
        }
    ]
}
```

  </ul>
 </details>


 <details markdown = "1">
  <summary>보드 생성 : api/board/create (POST)</summary>
    <ul>
      <li>Header</li>
      
```json
{
	"Header" : {
		"Authoriztion" : "Bearer " + localstorge.getItem(token),
		"Content-Type" : "application/json" 
			}
}
```

  <li>Request Body </li>  

```json
{
    "boardTitle": "실험 제목",
    "boardDescription": "새롭게2 설명",
    "boardCategory": "새로운2 카테고리",
    "boardImage": "새롭게 이미지 URL",
    "boardWriterId": "1234",
    "boardWriterFanclub" : "세븐틴",
    "boardWriterNickname": "게시물 작성자 닉네임"
}
```

  <li>Response body</li>  

```json
{
    "result": true,
    "message": "Board Create Success",
    "data": null
}
```

  </ul>
 </details>



<br>

 

<!-- Stack Icon Refernces -->

[sp]: /readme/spring.png
[ec2]: /readme/EC2.png
[pm]: /readme/postman.png
