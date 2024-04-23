package jun.playlist.hander;

public class PlayListHandlerAdapter {
	// 특정 페이지에 대한 이동에 대한 응답으로 forward로 페이지 이동한다.
	private boolean redirect = false;
	// 경로를 설정하여 저장하고자 하는 파일을 저장한다.
	private String path = null;

	public boolean isRedirect() {
		return redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
/*
 * 이 코드는 웹 애플리케이션에서 특정 페이지로의 이동에 대한 응답을 처리하기 위한 클래스인 PlayListHandlerAdapter를
 * 정의합니다. 이 클래스는 컨트롤러가 처리한 결과를 담고, 클라이언트에게 전달할 View의 경로를 저장합니다.
 * 
 * 주요 요소는 다음과 같습니다:
 * 
 * redirect 필드:
 * 
 * 이동 방식을 나타내는 boolean 값입니다. redirect가 true로 설정되면, 클라이언트에게 리다이렉트할 것임을 의미합니다.
 * false로 설정되면, forward를 통해 지정된 경로로 이동할 것임을 의미합니다. path 필드:
 * 
 * 클라이언트에게 보여줄 View의 경로를 저장합니다. 이동할 JSP 페이지의 경로를 나타냅니다. 설정된 경로에 따라 클라이언트는 새로운
 * 페이지로 이동하거나, 현재 페이지에서의 처리 결과를 보여줍니다.
 * 
 * Getter와 Setter 메서드:
 * 
 * isRedirect()와 getRedirect()는 redirect 필드의 값을 반환합니다. setRedirect(boolean
 * redirect)는 redirect 필드의 값을 설정합니다. getPath()와 setPath(String path)는 path 필드의
 * 값을 반환하거나 설정합니다. 이 클래스는 주로 컨트롤러가 처리한 결과와 이동할 페이지의 정보를 담아서 반환하기 위해 사용됩니다. 이를 통해
 * 컨트롤러와 뷰 간의 데이터 전달 및 페이지 이동을 관리할 수 있습니다.
 */