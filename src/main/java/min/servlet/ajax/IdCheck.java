package min.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class IdCheck extends HttpServlet {
	private static Log log = LogFactory.getLog(IdCheck.class);

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 웹 클라이언트로부터 전달받은 아이디 값을 할당한다.
		String id = request.getParameter("id");
		log.info("아이디 - " + id);
		// 웹 클라이언트에서 전송할 아이디 체크에 대한 결괏값을 설정한다.
		int result = 1;
		try {
			// 웹 클라이언트에 응답하기 위한 출력 스트림을 가져와서 문자 텍스트를 출력할 수 있는 PrintWriter 객체에 할당한다.
			PrintWriter out = response.getWriter();
			// 빈문자열을 연결하여 문자열로 변환하지 않으면 웹 클라이언트에서 결괏값이 정확하게 전달되지 않는다.
			out.write(result + "");
			// 사용한 리소스를 해제하고 출력 버퍼를 비우고 클라이언트에게 즉시 응답을 전송한다.
			out.close();
		} catch (IOException e) {
			e.printStackTrace();

		}

	}
}