package jun.playlist.control;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jun.playlist.hander.PlayListHandlerAdapter;

public interface PlayListController {
	// 비즈니스 요청을 수행하고 결괏값을 반환하는 공통기능인 execute 메서드를 설정한다.
	public PlayListHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response);

}
/*
 * 이 코드는 Java 웹 애플리케이션에서 사용되는 컨트롤러의 인터페이스를 정의합니다. 이 인터페이스를 구현하는 클래스들은 특정한 비즈니스
 * 요청을 처리하고, 그 결과를 반환하는 공통 기능을 제공해야 합니다.
 * 
 * 여기서 주요한 요소는 다음과 같습니다:
 * 
 * PlayListController 인터페이스:
 * 
 * PlayListController는 비즈니스 요청을 처리하기 위한 메서드를 정의하는 인터페이스입니다. 이 인터페이스는 execute
 * 메서드를 정의합니다. 이 메서드는 HTTP 요청을 처리하고, 클라이언트로부터의 요청에 대한 응답을 생성합니다. execute 메서드는
 * HttpServletRequest와 HttpServletResponse를 매개변수로 받습니다. 이를 통해 클라이언트의 요청을 받아들이고,
 * 적절한 응답을 생성할 수 있습니다. execute 메서드는 PlayListHandlerAdapter 객체를 반환합니다. 이 객체는 해당
 * 요청에 대한 처리 결과와 클라이언트에게 보여줄 View의 경로 등을 담고 있습니다.
 * 
 * PlayListHandlerAdapter:
 * 
 * PlayListHandlerAdapter는 클라이언트에게 보여줄 View의 경로를 담는 객체입니다. 이를 통해 컨트롤러가 처리한 결과를
 * 어떤 JSP 페이지에 표시할지 결정할 수 있습니다. 이 인터페이스는 컨트롤러에서 생성된 데이터와 JSP 페이지의 경로를 효과적으로 전달하기
 * 위해 사용됩니다. 이 인터페이스를 구현하는 클래스들은 각자의 비즈니스 로직에 따라 execute 메서드를 구현하여 요청을 처리하고, 적절한
 * 결과를 생성하게 됩니다. 이를 통해 웹 애플리케이션은 각 요청에 대한 처리를 담당하는 컨트롤러 클래스를 통해 모듈화되고, 유지보수가
 * 용이해집니다.
 */