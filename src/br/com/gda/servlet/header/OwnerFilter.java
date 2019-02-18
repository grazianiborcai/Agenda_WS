package br.com.gda.servlet.header;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.filter.GenericFilterBean;
import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.json.JsonToList;
import br.com.gda.model.ModelHelper;

public final class OwnerFilter extends GenericFilterBean {
	
	public OwnerFilter() {
		super();
	}

	
	
	@Override public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest requestWrapper = new RequestWrapper(request);	
		String owner = getOwner(requestWrapper);
		
		if (shouldFilter(owner)) {
			if (isParamValid(owner, requestWrapper) == false) {
				((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED);	//TODO: melhorar resposta
				return;
			}
		}
		
		
		chain.doFilter(requestWrapper, response);
	}
	
	
	
	private String getOwner(HttpServletRequest request) {
		String owner = request.getHeader("codOwner");
		
		if (owner == null)
			return null;
		
		return owner.trim();
	}
	
	
	
	private boolean shouldFilter(String owner) {
		if (owner == null) {
			return false; 
		} else {
			return true;
		}
	}
    
    
    
    private boolean isParamValid(String owner, HttpServletRequest request) {
    	long codOwner = stringToLong(owner);    	
    	String body = getRequestBody(request);    	
    	List<OwnerInfo> codOwners = parseRawInfo(body);
    	
    	if (codOwners == null)
    		return true;
    	
    	if (codOwners.isEmpty())
    		return true;
    	
    	for (OwnerInfo eachOwner : codOwners) {
    		if (eachOwner.codOwner != codOwner) {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    
    
    private long stringToLong(String owner) {
		try {
	    	if (owner == null) {
				return DefaultValue.number();
	    	} else {	    	
	    		return Long.valueOf(owner);
	    	}
		
		} catch (NumberFormatException e) {
			return DefaultValue.number();
		}
    }
    
    
    
    private String getRequestBody(HttpServletRequest request) {
		try {	 
			return IOUtils.toString(request.getInputStream(), Charset.forName("UTF-8").toString());
	    	
	
		} catch (IOException e) {
			 logException(e);
			 throw new IllegalArgumentException();	//TODO: melhorar essa exception. Do jeito que esta a msg ao usuario fica estranha
		}
    }
    
    
    
	private List<OwnerInfo> parseRawInfo(String requestBody) {
		JsonToList<OwnerInfo> parser = new JsonToList<>(OwnerInfo.class);
		return parser.parse(requestBody);
	}
	
	
	
	private static void logException(Exception e) {
		Logger logger = LogManager.getLogger(ModelHelper.class);
		logger.error(e.getMessage(), e);
	}
}
