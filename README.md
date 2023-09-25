# login-with-redis

* Redis를 DB로 하여 만들어본 회원가입 및 로그인 서비스입니다.


## Library & Framework
|Item| Version |
|---|---|
|BootStrap| 5.3.0 |
|lombok||
|spring-boot-starter-thymeleaf||
|spring-boot-starter-data-redis||

## 화면

* Thymeleaf와 Bootstrap을 이용해 회원가입/로그인을 할 수 있는 화면을 간단하게 만들었습니다.
* `com.example.loginwithredis.IndexController`를 만들어서 기본 URL로 접속해도 로그인화면으로 Redirection되도록 했습니다.
  * ex. http://localhost:8080 -> http://localhost:8080/user/login.do

<img src=./img/01_loginpage.png>

<br>

<hr>

## Password

* 패스워드는 한번 정해지면 다시 복호화할 수 없도록 Hash함수를 사용해 암호화했습니다.
* `com.example.loginwithredis.util.SecurityUtil`
