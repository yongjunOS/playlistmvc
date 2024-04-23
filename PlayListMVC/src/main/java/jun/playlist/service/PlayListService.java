package jun.playlist.service;

import java.util.ArrayList;

import jun.playlist.dto.PlayListDTO;

public interface PlayListService {
	public ArrayList<PlayListDTO> playlistSelectAll();

	public PlayListDTO playlistSelect(int PLAYLIST_NUM);

	public PlayListDTO playlistInsert(PlayListDTO playListDTO);

	public PlayListDTO playlistUpdate(PlayListDTO playListDTO);

	public PlayListDTO playlistDelete(PlayListDTO playListDTO);
}
