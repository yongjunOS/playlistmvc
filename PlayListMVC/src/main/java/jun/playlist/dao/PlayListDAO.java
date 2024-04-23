package jun.playlist.dao;

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

import jun.playlist.dto.PlayListDTO;
import jun.playlist.service.PlayListService;

public class PlayListDAO implements PlayListService {
	private static Log log = LogFactory.getLog(PlayListDTO.class);

	@Override
	public ArrayList<PlayListDTO> playlistSelectAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<PlayListDTO> arrayList = new ArrayList<PlayListDTO>();

		try {

			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "select PLAYLIST_NUM, USER_ID, PLAYLIST_DESCRIPTION, PLAYLIST_TITLE from PLAYLISTS";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				PlayListDTO playListDTO = new PlayListDTO();
				playListDTO.setPLAYLIST_NUM(resultSet.getInt("PLAYLIST_NUM"));
				playListDTO.setPLAYLIST_TITLE(resultSet.getString("PLAYLIST_TITLE"));
				playListDTO.setUSER_ID(resultSet.getString("USER_ID"));
				playListDTO.setPLAYLIST_DESCRIPTION(resultSet.getString("PLAYLIST_DESCRIPTION"));

				arrayList.add(playListDTO);
			}

			// 현재 행 번호를 검색한다.
			resultSet.getRow();
			if (resultSet.getRow() == 0) {
				log.info("만든 재생목록이 없습니다. 재생목록을 등록해 주세요");
			}
		} catch (Exception e) {
			log.info("전체 재생목록 조회 실패 - " + e);
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

	public PlayListDTO playlistSelect(int PLAYLIST_NUM) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		PlayListDTO playListDTO = new PlayListDTO();
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "select PLAYLIST_NUM, USER_ID, PLAYLIST_DESCRIPTION, PLAYLIST_TITLE from PLAYLISTS";
			sql += " where PLAYLIST_NUM = ? ";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, PLAYLIST_NUM);
			// SQL인 select...from...where 문을 실행하고 데이터를 조회한다.
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				playListDTO.setPLAYLIST_NUM(resultSet.getInt("PLAYLIST_NUM"));
				playListDTO.setPLAYLIST_TITLE(resultSet.getString("PLAYLIST_TITLE"));
				playListDTO.setUSER_ID(resultSet.getString("USER_ID"));
				playListDTO.setPLAYLIST_DESCRIPTION(resultSet.getString("PLAYLIST_DESCRIPTION"));

			}

		} catch (Exception e) {
			log.info("특정 재생목록 조회 실패 - " + e);
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return playListDTO;
	}

	public PlayListDTO playlistInsert(PlayListDTO playListDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
//		ResultSet generatedKeys = null; // 생성된 키 값을 가져오기 위한 ResultSet 변수
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "insert into PLAYLISTS (PLAYLIST_NUM, USER_ID, PLAYLIST_TITLE, PLAYLIST_DESCRIPTION)";
			sql += " values ( playlist_num_seq.NEXTVAL , ? , ? ,?) ";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setInt(1, playListDTO.getPLAYLIST_NUM());
			preparedStatement.setString(1, playListDTO.getUSER_ID());
			preparedStatement.setString(2, playListDTO.getPLAYLIST_TITLE());
			preparedStatement.setString(3, playListDTO.getPLAYLIST_DESCRIPTION());
			connection.setAutoCommit(false); // 수동 커밋 활성화
			// SQL인 insert...into...values 문을 실행하고 데이터를 입력한다.
			int count = preparedStatement.executeUpdate();

			// 재생목록 등록 코드
			if (count > 0) {
				connection.commit(); // 수동으로 커밋
				log.info("커밋되었습니다.");
			} else {
				connection.rollback(); // 롤백
				log.info("롤백되었습니다.");
			}

		} catch (Exception e) {
			log.info("재생목록 만들기 실패 - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return playListDTO;
	}

	public PlayListDTO playlistUpdate(PlayListDTO playListDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			connection.setAutoCommit(false); // 수동 커밋 활성화

			String sql = "update PLAYLISTS set PLAYLIST_TITLE = ?, PLAYLIST_DESCRIPTION = ?";
			sql += " where PLAYLIST_NUM = ? and USER_ID = ?";
			log.info("SQL 확인 - " + sql);

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, playListDTO.getPLAYLIST_TITLE());
			preparedStatement.setString(2, playListDTO.getPLAYLIST_DESCRIPTION());
			preparedStatement.setInt(3, playListDTO.getPLAYLIST_NUM());
			preparedStatement.setString(4, playListDTO.getUSER_ID());

			// SQL인 insert...into...values 문을 실행하고 데이터를 입력한다.
			int count = preparedStatement.executeUpdate();

			// 재생목록 등록 코드
			if (count > 0) {
				connection.commit(); // 수동으로 커밋
				log.info("커밋되었습니다.");
			} else {
				connection.rollback(); // 롤백
				log.info("롤백되었습니다.");
			}

		} catch (Exception e) {
			log.info("재생목록 수정 실패 - " + e);
			try {
				if (connection != null) {
					connection.rollback(); // 에러 발생 시 롤백
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return playListDTO;
	}

	public PlayListDTO playlistDelete(PlayListDTO playListDTO) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();

			// auto-commit을 비활성화하여 수동으로 커밋과 롤백을 관리
			connection.setAutoCommit(false); // 수동 커밋 활성화

			String sql = " delete from PLAYLISTS where PLAYLIST_NUM = ? ";
			log.info(" SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, playListDTO.getPLAYLIST_NUM());

			int count = preparedStatement.executeUpdate();

			if (count > 0) {
				connection.commit(); // 수동으로 커밋
				log.info("커밋되었습니다.");
			} else {
				connection.rollback(); // 롤백
				log.info("롤백되었습니다.");
			}

		} catch (Exception e) {
			log.info("재생목록 삭제 실패 - " + e);
			try {
				if (connection != null) {
					connection.rollback(); // 에러 발생 시 롤백
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}