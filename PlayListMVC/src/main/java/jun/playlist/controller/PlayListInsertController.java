package jun.playlist.controller;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jun.playlist.control.PlayListController;
import jun.playlist.dao.PlayListDAO;
import jun.playlist.dto.PlayListDTO;
import jun.playlist.hander.PlayListHandlerAdapter;

public class PlayListInsertController implements PlayListController {
	private static Log log = LogFactory.getLog(PlayListInsertController.class);

	@Override
	public PlayListHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
//		int PLAYLIST_NUM = Integer.parseInt(request.getParameter("PLAYLIST_NUM"));
//		log.info(PLAYLIST_NUM);
		String USER_ID = request.getParameter("USER_ID");
		log.info(USER_ID);
		String PLAYLIST_TITLE = request.getParameter("PLAYLIST_TITLE");
		log.info(PLAYLIST_TITLE);
		String PLAYLIST_DESCRIPTION = request.getParameter("PLAYLIST_DESCRIPTION");
		log.info(PLAYLIST_DESCRIPTION);

		PlayListDAO playListDAO = new PlayListDAO();
		PlayListDTO playListDTO = new PlayListDTO();
		ArrayList<PlayListDTO> arrayList = new ArrayList<PlayListDTO>();
		// 가변 배열에 추가한 전체 데이터를 반환하여 arrayList 인스턴스로 할당하고 할당하지 않으면 null 값이 반환된다.
		arrayList = playListDAO.playlistSelectAll();
		log.info(arrayList);
		request.setAttribute("arrayList", arrayList);
//		playListDTO.setPLAYLIST_NUM(PLAYLIST_NUM);
		playListDTO.setUSER_ID(USER_ID);
		playListDTO.setPLAYLIST_TITLE(PLAYLIST_TITLE);
		playListDTO.setPLAYLIST_DESCRIPTION(PLAYLIST_DESCRIPTION);
		playListDTO = playListDAO.playlistInsert(playListDTO);
		log.info(playListDTO);
		request.setAttribute("playlistDTO", playListDTO);

		log.info("재생목록 등록");
		PlayListHandlerAdapter playListHandlerAdapter = new PlayListHandlerAdapter();
		playListHandlerAdapter.setPath("/WEB-INF/playlist/playlist_insert_view.jsp");
		return playListHandlerAdapter;

	}

}