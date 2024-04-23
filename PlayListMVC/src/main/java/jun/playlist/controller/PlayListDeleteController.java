package jun.playlist.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jun.playlist.control.PlayListController;
import jun.playlist.dao.PlayListDAO;
import jun.playlist.dto.PlayListDTO;
import jun.playlist.hander.PlayListHandlerAdapter;

public class PlayListDeleteController implements PlayListController {
	private static Log log = LogFactory.getLog(PlayListDeleteController.class);

	@Override
	public PlayListHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		int PLAYLIST_NUM = Integer.parseInt(request.getParameter("PLAYLIST_NUM"));
		log.info(PLAYLIST_NUM);
		PlayListDAO playListDAO = new PlayListDAO();
		PlayListDTO playListDTO = new PlayListDTO();
		playListDTO.setPLAYLIST_NUM(PLAYLIST_NUM);
		request.setAttribute("playListDTO", playListDTO);
		playListDTO = playListDAO.playlistDelete(playListDTO);
		log.info(playListDTO);
		PlayListHandlerAdapter playListHandlerAdapter = new PlayListHandlerAdapter();
		playListHandlerAdapter.setPath("/WEB-INF/playlist/playlist_delete_view.jsp");
		return playListHandlerAdapter;
	}

}
