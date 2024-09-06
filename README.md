# 서블릿과 JSP를 활용한 재생목록 웹 애플리케이션 개발


## 기술 스택
- Java 11
- JSP (JavaServer Pages)
- Servlets
- JDBC (Java Database Connectivity)
- HTML/CSS
- JavaScript
- Bootstrap 4.5.0
- jQuery 3.5.1
- Apache Tomcat 10
- Oracle Database

## 프로젝트 구조
```
JAVABOZA/
├── src/
│   └── jun/
│       └── playlist/
│           ├── control/
│           │   └── PlayListController.java
│           ├── controller/
│           │   ├── PlayListDeleteController.java
│           │   ├── PlayListInsertController.java
│           │   ├── PlayListSelectController.java
│           │   ├── PlayListSelectDetailController.java
│           │   ├── PlayListUpdateController.java
│           │   └── PlayListUpdateViewController.java
│           ├── dao/
│           │   └── PlayListDAO.java
│           ├── dbcp/
│           │   └── PlayListDBCP.java
│           ├── dto/
│           │   └── PlayListDTO.java
│           ├── filter/
│           │   └── CharacterEncodingFilter.java
│           ├── frontcontrol/
│           │   └── PlayListDispatcher.java
│           ├── hander/
│           │   └── PlayListHandlerAdapter.java
│           └── service/
│               └── PlayListService.java
├── WebContent/
│   ├── WEB-INF/
│   │   └── playlist/
│   │       ├── playlist_delete.jsp
│   │       ├── playlist_delete_view.jsp
│   │       ├── playlist_insert.jsp
│   │       ├── playlist_insert_view.jsp
│   │       ├── playlist_select_detail_view.jsp
│   │       ├── playlist_select_view.jsp
│   │       ├── playlist_update.jsp
│   │       └── playlist_update_view.jsp
│   ├── css/
│   │   └── bootstrap.min_4.5.0.css
│   ├── js/
│   │   ├── bootstrap.min_4.5.0.js
│   │   └── jquery-3.5.1.min.js
│   └── index.jsp
└── README.md
```

## 주요 기능
1. **플레이리스트 관리**
   - 플레이리스트 조회
   - 플레이리스트 생성
   - 플레이리스트 수정
   - 플레이리스트 삭제
   - 플레이리스트 상세 조회

2. **데이터베이스 연결 풀 (DBCP) 사용**
   - 효율적인 데이터베이스 연결 관리

3. **MVC 아키텍처 적용**
   - Model (DTO, DAO)
   - View (JSP)
   - Controller (Servlets)



#### 주요 구성요소

1. 모델 (Model):
   - PlayListDTO: 재생 목록의 데이터를 표현하는 Data Transfer Object
   - PlayListDAO: 데이터베이스 작업을 처리하는 Data Access Object
2. 뷰 (View):
   - JSP 파일
3. 컨트롤러 (Controller):
   - PlayListController (인터페이스)
   - 각종 구체적인 컨트롤러 클래스들 (PlayListSelectController, PlayListInsertController 등)
4. 프론트 컨트롤러:
   - PlayListDispatcher: 모든 요청을 받아 적절한 컨트롤러로 라우팅하는 서블릿
5. 유틸리티 및 설정:
   - PlayListDBCP: 데이터베이스 연결 풀 설정
   - CharacterEncodingFilter: 문자 인코딩을 처리하는 필터
   - PlayListHandlerAdapter: 컨트롤러의 실행 결과를 처리하는 어댑터
6. 서비스 계층:
   - PlayListService (인터페이스): DAO와 컨트롤러 사이의 비즈니스 로직을 정의
  

## 실행화면
#### 재생목록 메인페이지
<img width="929" alt="image" src="https://github.com/user-attachments/assets/c30c6904-1836-489a-b8a0-28abbe9f5952">

---
#### 재생목록 생성페이지  
<img width="786" alt="image" src="https://github.com/user-attachments/assets/08e4ef86-1810-4511-a910-7c29e3db4e81">

---
#### 재생목록 상세페이지
<img width="945" alt="image" src="https://github.com/user-attachments/assets/51ec3d90-66b1-4967-ba50-ca99d65d2fe8">

---
#### 재생목록 수정페이지
<img width="506" alt="image" src="https://github.com/user-attachments/assets/ba42d822-e4fb-4247-97dd-c8f0e3301c5a">

---
#### 재생목록 삭제페이지
<img width="804" alt="image" src="https://github.com/user-attachments/assets/cee48788-b05c-42e3-bfbd-72a2b32a87bf">
