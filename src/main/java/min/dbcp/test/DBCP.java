package min.dbcp.test;

//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.SQLException;
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.sql.DataSource;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DBCP extends HttpServlet {
	private static Log log = LogFactory.getLog(DBCP.class);
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection = null;
		try {
			// 초기 컨텍스트는 Context 인터페이스를 구현하고 이름 확인을 위한 시작점을 제공한다.
			Context context = new InitialContext();
			// 연결할 정보의 이름을 검색하고 할당한다.
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			// 커넥션 객체를 생성한다.
			connection = dataSource.getConnection();
			log.info(connection);
			log.info("데이터베이스와 연결되었습니다.");
		} catch (Exception e) {
			log.info("데이터베이스 연결 실패 - " + e);
			// 자원 해제를 한다.
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}