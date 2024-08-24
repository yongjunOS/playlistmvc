# SpirngMVC패턴을 활용한 재생목록 CURD


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

