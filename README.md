# LoginWithRedis

## Redis를 이용한 회원가입/로그인 예제

### 1. WEB

#### 로그인 화면
`/user/login.do`로 접속
<br>
<img width="497" alt="로그인화면" src="https://github.com/pongdangx2/LoginWithRedis/assets/32296630/d37546b7-d444-48a5-add1-f0f059773a05">

#### 회원가입 화면
<img width="503" alt="회원가입성공" src="https://github.com/pongdangx2/LoginWithRedis/assets/32296630/61f2f53f-8022-45e7-9d98-b38c2d7bc493">

#### 로그인 화면
<img width="501" alt="로그인성공" src="https://github.com/pongdangx2/LoginWithRedis/assets/32296630/7cd03729-98f7-4a2d-bf92-6d423be87489">

<br>

<hr>

### 2. API

#### URI
|설명|URI|
|---|---|
|회원가입|/user/join|
|로그인|/user/signIn|

<br>

#### Request Body
|파라미터명|설명|
|---|---|
|id|사용자 ID|
|password|패스워드|

<br>

* ex)
```
{
    "id":"user id",
    "password":"password"
}
```

<br>

#### Response Body
|코드(code)|메시지(message)|설명|
|---|---|---|
|00|성공|로그인/회원가입 성공한 경우|
|01|처리중 에러가 발생하였습니다.|런타임 에러 발생한 경우|
|10|중복된 ID 입니다.|회원가입 시 이미 ID가 존재하는 경우|
|11|존재하지 않는 ID 입니다.|로그인 시 ID가 존재하지 않는 경우|
|20|패스워드가 일치하지 않습니다.|로그인 시 패스워드가 일치하지 않는 경우|

<br>

* ex) 
```
{
    "code": "00",
    "message": "SUCCESS"
}
```
