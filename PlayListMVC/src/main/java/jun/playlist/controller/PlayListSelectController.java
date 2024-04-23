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

public class PlayListSelectController implements PlayListController {
	private static Log log = LogFactory.getLog(PlayListSelectController.class);

	@Override
	public PlayListHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		PlayListDAO playListDAO = new PlayListDAO();
		PlayListDTO playListDTO = new PlayListDTO();

		log.info(playListDTO);

		ArrayList<PlayListDTO> arrayList = new ArrayList<PlayListDTO>();
		arrayList = playListDAO.playlistSelectAll();

		log.info(arrayList);
		request.setAttribute("arrayList", arrayList);

		// arrayList에서 첫 번째 사용자의 user_id를 가져옴
		String firstUserId = arrayList.isEmpty() ? "" : arrayList.get(0).getUSER_ID();
		// PlayListInsert.pl 링크에 user_id 파라미터를 포함하여 생성
		String insertPlaylistLink = "./PlayListInsert.pl?USER_ID=" + firstUserId;

		// request에 insertPlaylistLink를 attribute로 추가
		request.setAttribute("insertPlaylistLink", insertPlaylistLink);

		PlayListHandlerAdapter playListHandlerAdapter = new PlayListHandlerAdapter();
		log.info("재생 목록 조회");
		playListHandlerAdapter.setPath("/WEB-INF/playlist/playlist_select_view.jsp");

		return playListHandlerAdapter;
	}
}
