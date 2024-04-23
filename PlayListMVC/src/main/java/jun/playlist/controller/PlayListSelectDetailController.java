package jun.playlist.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jun.playlist.control.PlayListController;
import jun.playlist.dao.PlayListDAO;
import jun.playlist.dto.PlayListDTO;
import jun.playlist.hander.PlayListHandlerAdapter;

public class PlayListSelectDetailController implements PlayListController {
	private static Log log = LogFactory.getLog(PlayListSelectDetailController.class);

	@Override
	public PlayListHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		int PLAYLIST_NUM = Integer.parseInt(request.getParameter("PLAYLIST_NUM"));
		log.info(PLAYLIST_NUM);
		PlayListDAO playListDAO = new PlayListDAO();
		PlayListDTO playListDTO = new PlayListDTO();

		// 조회한 데이터를 반환하여 deptDTO 인스턴스로 할당하고 할당하지 않으면 null 값이 반환된다.
		playListDTO = playListDAO.playlistSelect(PLAYLIST_NUM);
		log.info(playListDTO);

		request.setAttribute("playListDTO", playListDTO);
		PlayListHandlerAdapter playListHandlerAdapter = new PlayListHandlerAdapter();
		log.info("특정 재생목록 조회");
		playListHandlerAdapter.setPath("/WEB-INF/playlist/playlist_select_detail_view.jsp");
		return playListHandlerAdapter;
	}

}
