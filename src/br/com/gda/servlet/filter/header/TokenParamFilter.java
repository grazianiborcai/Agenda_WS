package br.com.gda.servlet.filter.header;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.filter.GenericFilterBean;
import br.com.gda.servlet.filter.common.HeaderParam;
import br.com.gda.servlet.filter.common.RequestWrapper;

public final class TokenParamFilter extends GenericFilterBean {
	
	public TokenParamFilter() {
		super();
	}

	
	
	@Override public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest requestWrapper = new RequestWrapper(request);	
		TokenParamInfo headerParam = parseHeader(requestWrapper);
		
		if (checkHeaderParam(headerParam) == false) {
			response = onError(response);			
		} else {		
			chain.doFilter(requestWrapper, response);
		}
		
		return;
	}
	
	
	
	private TokenParamInfo parseHeader(HttpServletRequest request) {
		TokenParamInfo headerParam = new TokenParamInfo();
		
		headerParam.tokenOwner = request.getHeader(HeaderParam.TOKEN_OWNER);
		headerParam.tokenUsername = request.getHeader(HeaderParam.TOKEN_USERNAME);
		headerParam.tokenPlatform = request.getHeader(HeaderParam.TOKEN_PLATFORM);
		
		return headerParam;
	}
	
	
	
	private boolean checkHeaderParam(TokenParamInfo headerParam) {
		if(headerParam == null)
			return true;
		
		if(headerParam.tokenOwner != null)
			return false;
		
		if(headerParam.tokenUsername != null)
			return false;
		
		if(headerParam.tokenPlatform != null)
			return false;
		
		return true;
	}
	
	
	
	private ServletResponse onError(ServletResponse response) throws IOException {
		((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED);	//TODO: melhorar resposta
		return response;
	}
}
