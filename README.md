##  Java EE (Java Enterprise Edition) 기반의 웹 애플리케이션


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

주요 특징:

1. 프론트 컨트롤러 패턴을 사용하여 모든 요청을 중앙에서 처리
2. DAO 패턴을 사용하여 데이터베이스 작업을 추상화
3. DBCP(Database Connection Pool)를 사용하여 데이터베이스 연결을 관리
4. 로깅을 위해 Apache Commons Logging을 사용
5. 트랜잭션 관리를 위해 수동 커밋 방식을 사용

