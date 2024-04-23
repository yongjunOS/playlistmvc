package jun.playlist.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jun.playlist.control.PlayListController;
import jun.playlist.dao.PlayListDAO;
import jun.playlist.dto.PlayListDTO;
import jun.playlist.hander.PlayListHandlerAdapter;

public class PlayListUpdateController implements PlayListController {
	private static Log log = LogFactory.getLog(PlayListUpdateController.class);

	@Override
	public PlayListHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		int PLAYLIST_NUM = Integer.parseInt(request.getParameter("PLAYLIST_NUM"));
		String USER_ID = request.getParameter("USER_ID");
		log.info(PLAYLIST_NUM);
		System.out.println(PLAYLIST_NUM);

		PlayListDAO playListDAO = new PlayListDAO();
		PlayListDTO playListDTO = new PlayListDTO();
		playListDTO.setUSER_ID(USER_ID); // 사용자 아이디 설정

		playListDTO = playListDAO.playlistSelect(PLAYLIST_NUM);
		request.setAttribute("playlistDTO", playListDTO);
		log.info(playListDTO);

		PlayListHandlerAdapter playListHandlerAdapter = new PlayListHandlerAdapter();
		log.info("특정 재생목록 조회");
		playListHandlerAdapter.setPath("/WEB-INF/playlist/playlist_update.jsp");
		return playListHandlerAdapter;
	}

}
