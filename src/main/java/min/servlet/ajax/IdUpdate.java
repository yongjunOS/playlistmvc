package min.servlet.ajax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class IdUpdate extends HttpServlet {
	private static Log log = LogFactory.getLog(IdUpdate.class);
	private static final long serialVersionUID = 1L;

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		InputStreamReader inputStreamReader = new InputStreamReader(request.getInputStream());
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String requestBody = bufferedReader.readLine();
		bufferedReader.close();
		String id = null;
		if (requestBody != null) {
			// 문자열의 앞뒤에 있는 공백을 제거하고 할당한다.
			id = requestBody.trim();
		}
		log.info("아이디 - " + id);
		int result = 1;
		// JSON 형식의 응답을 생성한다.
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter out = response.getWriter();
			// 빈문자열을 연결하여 문자열로 변환하지 않으면 웹 클라이언트에서 결괏값이 정확하게 전달되지 않는다.
			out.write(result + "");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
