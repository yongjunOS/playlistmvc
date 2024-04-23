package jun.playlist.dto;

public class PlayListDTO {
	private int PLAYLIST_NUM;
	private String USER_ID;
	private String PLAYLIST_DESCRIPTION;
	private String PLAYLIST_TITLE;

	public int getPLAYLIST_NUM() {
		return PLAYLIST_NUM;
	}

	public void setPLAYLIST_NUM(int pLAYLIST_NUM) {
		PLAYLIST_NUM = pLAYLIST_NUM;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getPLAYLIST_DESCRIPTION() {
		return PLAYLIST_DESCRIPTION;
	}

	public void setPLAYLIST_DESCRIPTION(String pLAYLIST_DESCRIPTION) {
		PLAYLIST_DESCRIPTION = pLAYLIST_DESCRIPTION;
	}

	public String getPLAYLIST_TITLE() {
		return PLAYLIST_TITLE;
	}

	public void setPLAYLIST_TITLE(String pLAYLIST_TITLE) {
		PLAYLIST_TITLE = pLAYLIST_TITLE;
	}

	@Override
	public String toString() {
		return "PlayListDTO [PLAYLIST_NUM=" + PLAYLIST_NUM + ", USER_ID=" + USER_ID + ", PLAYLIST_DESCRIPTION="
				+ PLAYLIST_DESCRIPTION + ", PLAYLIST_TITLE=" + PLAYLIST_TITLE + "]";
	}

}
