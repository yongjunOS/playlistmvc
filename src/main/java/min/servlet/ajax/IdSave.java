package min.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class IdSave extends HttpServlet {
	private static Log log = LogFactory.getLog(IdSave.class);
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		log.info("아이디 -" + id);

		int result = 1;

		try {

			PrintWriter out = response.getWriter();
			out.write(result + "");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
