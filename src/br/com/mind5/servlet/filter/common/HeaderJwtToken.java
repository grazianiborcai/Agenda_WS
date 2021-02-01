package br.com.mind5.servlet.filter.common;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import br.com.mind5.servlet.filter.authentication.AuthJwtGenerate;
import br.com.mind5.servlet.filter.authentication.AuthToken;

public final class HeaderJwtToken {
	static private String HEADER_AUTH = "Authorization";
	static private String TOKEN_PREFIX = "Bearer";
	
	
	
	
	static public HttpServletResponse addJwtToken(HttpServletResponse response, AuthToken authToken) { 
		JwtokenInfo jwtoken = parseAuthToken(authToken);
		return addJwtToken(response, jwtoken);
	}
	
	
	
	static public HttpServletResponse addJwtToken(HttpServletResponse response, JwtokenInfo jwtoken) {		
		String jwtToken = customGenerateJwtToken(jwtoken);
		
		response.addHeader(HEADER_AUTH, TOKEN_PREFIX + " " + jwtToken);
		
		return response;
	}
	
	
	
	static public Response addJwtToken(Response response, JwtokenInfo jwtoken) {
		if(checkResponseStatus(response) == false)
			return response;
		
		String jwtToken = customGenerateJwtToken(jwtoken);
		return Response.ok(response.getEntity()).header(HEADER_AUTH, TOKEN_PREFIX + " " + jwtToken).build();
	}
	
	
	
	static private String customGenerateJwtToken(JwtokenInfo jwtoken) {
		DeciTree<JwtokenInfo> jwtokenGenerate = new AuthJwtGenerate(jwtoken);	
		jwtokenGenerate.makeDecision();
		customCheckJwtTokenGeneration(jwtokenGenerate.getDecisionResult());
		
		
		String result = jwtokenGenerate.getDecisionResult().getResultset().get(0).token;
		jwtokenGenerate.close();
		return result;
	}
	
	
	
	static private JwtokenInfo parseAuthToken(AuthToken authToken) {
		AuthToken customAuthToken = (AuthToken) authToken;
		
		JwtokenInfo jwtoken = new JwtokenInfo();
		jwtoken.codOwner = customAuthToken.getCodOwner();
		jwtoken.username = customAuthToken.getName();
		jwtoken.codPlatform = customAuthToken.getCodPlatform();
		
		if (shouldFallbackPlatform(jwtoken) == true)
			jwtoken = fallbackPlatform(jwtoken);
		
		return jwtoken;
	}
	
	
	
	static private JwtokenInfo fallbackPlatform(JwtokenInfo jwtoken) {
		if (shouldFallbackPlatform(jwtoken) == false)
			return jwtoken;
		
		jwtoken.codPlatform = Platform.WEB.getCodPlatform();
		
		return jwtoken;
	}
	
	
	
	static private boolean shouldFallbackPlatform(JwtokenInfo jwtoken) {
		if (jwtoken.codPlatform == null)
			return true;
		
		if (jwtoken.codPlatform.equals(Platform.MOBILE.getCodPlatform()))
			return false;
		
		if (jwtoken.codPlatform.equals(Platform.WEB.getCodPlatform()))
			return false;
		
		return false;
	}
	
	
		
	static private void customCheckJwtTokenGeneration(DeciResult<JwtokenInfo> deciResult) {
		if (deciResult.isSuccess() == false)
			SystemLog.logError(HeaderJwtToken.class, new IllegalStateException(deciResult.getFailMessage()));
		
		if (deciResult.hasResultset() == false)
			SystemLog.logError(HeaderJwtToken.class, new IllegalStateException(SystemMessage.INTERNAL_ERROR));
	}
	
	
	
	static private boolean checkResponseStatus(Response response) {
		if (response == null)
			return false;
		
		
		return response.getStatus() == Response.Status.OK.getStatusCode();
	}
}
