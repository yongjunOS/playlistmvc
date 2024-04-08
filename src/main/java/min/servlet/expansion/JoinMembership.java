package min.servlet.expansion;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JoinMembership extends HttpServlet {

	private static Log log = LogFactory.getLog(JoinMembership.class);
	private static final long serialVersionUID = 1L;

	public JoinMembership() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./program/join_membership.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String[] hobbyAarray = request.getParameterValues("hobby");

		String hobby = "";
		for (int i = 0; i < hobbyAarray.length; i++) {
			hobby += hobbyAarray[i] + " ";
		}
		log.info(hobby);
		JoinMembershipDTO membershipDTO = new JoinMembershipDTO();
		membershipDTO.setName(name);
		membershipDTO.setId(id);
		membershipDTO.setPassword(password);
		membershipDTO.setGender(gender);
		membershipDTO.setHobby(hobby);
		log.info(membershipDTO);
		// 속성에 DTO 객체를 속성값으로 저장한다.
		request.setAttribute("membershipDTO", membershipDTO);
		RequestDispatcher dispatcher = request.getRequestDispatcher("./program/join_membership_view.jsp");
		dispatcher.forward(request, response);

	}

}
