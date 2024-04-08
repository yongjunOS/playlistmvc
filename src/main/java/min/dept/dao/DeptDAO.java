package min.dept.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import min.dept.dto.DeptDTO;
import min.dept.service.DeptService;

public class DeptDAO implements DeptService {
	private static Log log = LogFactory.getLog(DeptDAO.class);

	@Override
	public ArrayList<DeptDTO> deptSelectAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<DeptDTO> arrayList = new ArrayList<DeptDTO>();
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "select deptno, dname, loc from dept";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			// SQL 문인 select…from…where 문을 실행하고 데이터를 조회한다.
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				DeptDTO deptDTO = new DeptDTO();
				deptDTO.setDeptno(resultSet.getInt("deptno"));
				deptDTO.setDname(resultSet.getString("dname"));
				deptDTO.setLoc(resultSet.getString("loc"));
				// 저장한 정보를 DeptDTO 클래스의 인스턴스에 추가한다.
				arrayList.add(deptDTO);
			}
			// 현재 행 번호를 검색한다.
			resultSet.getRow();
			if (resultSet.getRow() == 0) {
				log.info("등록한 부서가 없습니다. 부서를 등록해 주세요");
			}
		} catch (Exception e) {
			log.info("전체 부서 조회 실패 - " + e);
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arrayList;
	}

//DeptDTO 클래스 반환 타입으로 특정 데이터를 조회한다.
	@Override
	public DeptDTO deptSelect(int deptno) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DeptDTO deptDTO = new DeptDTO();
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "select deptno, dname, loc from dept ";
			sql += " where deptno = ? ";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, deptno);
			// SQL 문인 select…from…where 문을 실행하고 데이터를 조회한다.
			resultSet = preparedStatement.executeQuery();
			// 커서를 현재 위치에서 한 행 앞으로 이동하면서 반복한다.
			while (resultSet.next()) {
				// 호출한 정보를 DeptDTO 클래스의 인스턴스에 저장한다.
				deptDTO.setDeptno(resultSet.getInt("deptno"));
				deptDTO.setDname(resultSet.getString("dname"));
				deptDTO.setLoc(resultSet.getString("loc"));
			}
		} catch (Exception e) {
			log.info("특정 부서 조회 실패 - " + e);
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return deptDTO;
	}

// DeptDTO 클래스 반환 타입으로 데이터를 입력한다.
	@Override
	public DeptDTO deptInsert(DeptDTO deptDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "insert into dept (deptno, dname, loc ) ";
			sql += " values ( ? , ? , ? ) ";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, deptDTO.getDeptno());
			preparedStatement.setString(2, deptDTO.getDname());
			preparedStatement.setString(3, deptDTO.getLoc());
			// SQL 문인 insert…into…values 문을 실행하고 데이터를 입력한다.
			int count = preparedStatement.executeUpdate();
			if (count > 0) {
				connection.commit();
				log.info("커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			log.info("부서 입력 실패 - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return deptDTO;
	}

// DeptDTO 클래스 반환 타입으로 데이터를 수정한다.
	@Override
	public DeptDTO deptUpdate(DeptDTO deptDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "update dept set dname = ?, loc = ? ";
			sql += " where  deptno = ?";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, deptDTO.getDname());
			preparedStatement.setString(2, deptDTO.getLoc());
			preparedStatement.setInt(3, deptDTO.getDeptno());
			// SQL 문인 update…set…where 문을 실행하고 데이터를 수정한다.
			int count = preparedStatement.executeUpdate();
			if (count > 0) {
				connection.commit();
				log.info("커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			log.info("부서 수정 실패 - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return deptDTO;
	}

// DeptDTO 클래스 반환 타입으로 데이터를 삭제한다.
	@Override
	public DeptDTO deptDelete(int deptno) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "delete from dept ";
			sql += " where  deptno = ?";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, deptno);
			// SQL 문인 delete…from…where 문을 실행하고 데이터를 삭제한다.
			int count = preparedStatement.executeUpdate();
			if (count > 0) {
				connection.commit();
				log.info("커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			log.info("부서 삭제 실패 - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
