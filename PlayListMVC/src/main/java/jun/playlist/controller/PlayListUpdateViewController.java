package jun.playlist.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jun.playlist.control.PlayListController;
import jun.playlist.dao.PlayListDAO;
import jun.playlist.dto.PlayListDTO;
import jun.playlist.hander.PlayListHandlerAdapter;

public class PlayListUpdateViewController implements PlayListController {
	private static Log log = LogFactory.getLog(PlayListUpdateViewController.class);

	@Override
	public PlayListHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		String USER_ID = request.getParameter("USER_ID");
		log.info(USER_ID);
		String PLAYLIST_TITLE = request.getParameter("PLAYLIST_TITLE");
		log.info(PLAYLIST_TITLE);
		String PLAYLIST_DESCRIPTION = request.getParameter("PLAYLIST_DESCRIPTION");
		log.info(PLAYLIST_DESCRIPTION);
		int PLAYLIST_NUM = Integer.parseInt(request.getParameter("PLAYLIST_NUM")); // PLAYLIST_NUM 받기
		log.info(PLAYLIST_NUM);

		PlayListDTO playListDTO = new PlayListDTO();
		playListDTO.setUSER_ID(USER_ID);
		playListDTO.setPLAYLIST_TITLE(PLAYLIST_TITLE);
		playListDTO.setPLAYLIST_DESCRIPTION(PLAYLIST_DESCRIPTION);
		playListDTO.setPLAYLIST_NUM(PLAYLIST_NUM); // PLAYLIST_NUM 설정

		PlayListDAO playListDAO = new PlayListDAO();

		playListDTO = playListDAO.playlistUpdate(playListDTO);
		log.info(playListDTO);

		request.setAttribute("playListDTO", playListDTO);
		PlayListHandlerAdapter playListHandlerAdapter = new PlayListHandlerAdapter();

		playListHandlerAdapter.setPath("/WEB-INF/playlist/playlist_update_view.jsp");

		return playListHandlerAdapter;
	}

}
