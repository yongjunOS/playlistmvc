package jun.playlist.frontcontrol;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jun.playlist.control.PlayListController;
import jun.playlist.controller.PlayListDeleteController;
import jun.playlist.controller.PlayListInsertController;
import jun.playlist.controller.PlayListSelectController;
import jun.playlist.controller.PlayListSelectDetailController;
import jun.playlist.controller.PlayListUpdateController;
import jun.playlist.controller.PlayListUpdateViewController;
import jun.playlist.hander.PlayListHandlerAdapter;

public class PlayListDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Log log = LogFactory.getLog(PlayListDispatcher.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		service(request, response);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// URL에서 포트 번호 다음부터 마지막 문자열인 http://localhost/컨텍스트명/매핑명으로 반환한다.
		String requestURI = request.getRequestURI();
		// URL에서 /(슬래시)를 첨부한 컨텍스트 이름인 /컨텍스트명/매핑명을 반환한다.
		String contextPath = request.getContextPath();
		// URL이 http://localhost/FrontDept/DeptSelect.do라면 /FrontDept/DeptSelect.do가
		// 반환된다.
		String pathURL = requestURI.substring(contextPath.length());
		log.info("매핑명 조회 - " + pathURL);
		// 객체를 처리하여 모델과 뷰에 반환한다.
		PlayListHandlerAdapter playListHandlerAdapter = null;
		// 서블릿 메서드를 규격화한다.
		PlayListController controller = null;
		// 전체 부서 조회의 매핑명을 설정한다.
		if (pathURL.equals("/PlayListSelect.pl")) {
			// 전체 부서 조회의 클래스를 인터페이스 객체에 할당한다.
			controller = new PlayListSelectController();
			// 서블릿 메서드를 핸들러 어댑터 객체에 할당한다.
			playListHandlerAdapter = controller.execute(request, response);
			log.info("재생목록 조회 확인 - " + playListHandlerAdapter);
		}
		// 상세 부서 정보 조회의 매핑명을 설정한다.
		else if (pathURL.equals("/PlayListSelectDetail.pl")) {
			// 상세 부서 정보 조회의 클래스를 인터페이스 객체에 할당한다.
			controller = new PlayListSelectDetailController();
			playListHandlerAdapter = controller.execute(request, response);
			log.info("재생목록 상세조회 확인 - " + playListHandlerAdapter);
		}

		// 부서 정보를 등록할 뷰의 매핑명을 설정한다.
		else if (pathURL.equals("/PlayListInsertView.pl")) { // 객체를 처리하여 모델과 뷰에 반환한다.
			playListHandlerAdapter = new PlayListHandlerAdapter(); // 포워드로 파라미터를 전송한다.

			playListHandlerAdapter.setPath("/WEB-INF/playlist/playlist_insert.jsp");
			log.info("재생목록 만들기 화면 뷰 확인 - " + playListHandlerAdapter);

		} else if (pathURL.equals("/PlayListInsert.pl")) {
			controller = new PlayListInsertController();
			playListHandlerAdapter = controller.execute(request, response);
			log.info("재생목록 등록 확인 - " + playListHandlerAdapter);

		} else if (pathURL.equals("/PlayListUpdateView.pl")) {
			controller = new PlayListUpdateViewController();
			playListHandlerAdapter = controller.execute(request, response);
			log.info("재생목록 수정화면 뷰 확인 - " + playListHandlerAdapter);
		}

		else if (pathURL.equals("/PlayListUpdate.pl")) {
			controller = new PlayListUpdateController();
			playListHandlerAdapter = controller.execute(request, response);
			log.info("재생목록 수정확인- " + playListHandlerAdapter);

		} else if (pathURL.equals("/PlayListDeleteView.pl")) {
			playListHandlerAdapter = new PlayListHandlerAdapter();
			playListHandlerAdapter.setPath("/WEB-INF/playlist/playlist_delete.jsp");
			log.info("재생목록 삭제뷰 확인 -" + playListHandlerAdapter);

		} else if (pathURL.equals("/PlayListDelete.pl")) {
			controller = new PlayListDeleteController();
			playListHandlerAdapter = controller.execute(request, response);
			log.info("재생목록 삭제 확인 - " + playListHandlerAdapter);

		}

		// isRedirect 메서드 값이 false이면 포워드 방식으로 처리하고 true이면 리다이렉트로 처리한다.
		if (playListHandlerAdapter != null) {
			// if 문의 조건이 false이므로 실행하지 않는다.
			if (playListHandlerAdapter.isRedirect()) {
				response.sendRedirect(playListHandlerAdapter.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(playListHandlerAdapter.getPath());
				dispatcher.forward(request, response);
			}

		}

	}
}
