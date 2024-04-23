package jun.playlist.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {

	FilterConfig config;

	@Override
	// 웹 컨테이너에 의해 호출되어 서비스에 배치되고 있음을 필터에 표시하고 필터를 초기화한다.
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
	}

	// 리소스에 대한 웹 브라우저 요청으로 인해 요청과 응답이 체인을 통해 전달될 때마다 컨테이너에 의해 호출된다.
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException { // web.xml 설정 파일의 <init-param> 태그에서 설정한 초기화 파라미터의 값을 읽어온다.
		request.setCharacterEncoding(config.getInitParameter("encoding"));
		// 체인의 다음 필터가 호출되도록 하거나 호출 필터가 체인의 마지막 필터인 경우 체인의 끝에 있는 리소스가 호출된다.
		chain.doFilter(request, response);
	}

	// 웹 컨테이너에서 호출되어 서비스에서 제외되고 있음을 필터에 표시하고 필터 객체를 제거한다.
	@Override
	public void destroy() {
	}
}