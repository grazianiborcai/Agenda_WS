package br.com.gda.servlet.authentication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import br.com.gda.business.masterData.info.AuthGrRoleInfo;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.tokenAuthentication.info.TauthInfo;

public final class AuthFilterJwtoken extends BasicAuthenticationFilter {
	private final String HEADER_STRING = "Authorization";
	private final String TOKEN_PREFIX = "Bearer ";

	
	public AuthFilterJwtoken(AuthenticationManager authenticationManager, AuthenticationEntryPoint authenticationEntryPoint) {
		super(authenticationManager, authenticationEntryPoint);
	}
	
	
	
	public AuthFilterJwtoken(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}
	
	
	
	@Override protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {        
		TauthInfo tauth = jwtokenAuthentication(req);        
        
        if (tauth == null) {
        	res = onError(res);
            return;
        }
        
        UsernamePasswordAuthenticationToken authentication = getAuthenticationToken(tauth);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }
    
    
    
    private TauthInfo jwtokenAuthentication(HttpServletRequest request) {
    	String token = getTokenHeader(request);  
    	
        if (token == null) 
    		return null;
    	
    	return authenticateToken(token);
    }
    
    
    
    private String getTokenHeader(HttpServletRequest request) {
    	String tokenHeader = request.getHeader(HEADER_STRING);  
    	
        if (tokenHeader == null || tokenHeader.startsWith(TOKEN_PREFIX) == false) 
    		return null;
        
        return tokenHeader.replace(TOKEN_PREFIX, "");
    }
    
    
    
    private TauthInfo authenticateToken(String token) {
    	TauthInfo tauth = makeRecord(token);
    	
    	DeciTree<TauthInfo> authenticator = new AuthJwtoken(tauth);
    	authenticator.makeDecision();
    	
    	return parseResult(authenticator.getDecisionResult());
    }
    
    
    
    private TauthInfo makeRecord(String token) {
    	TauthInfo tauth = new TauthInfo();
    	tauth.tokenToVerify = token;
    	return tauth;
    }
    
    
    
    private TauthInfo parseResult(DeciResult<TauthInfo> result) {
    	if (result.isSuccess() == false)
    		return null;
    	
    	if (result.hasResultset() == false)
    		return null;
    	
    	return result.getResultset().get(0);
    }
    
    
    
    private UsernamePasswordAuthenticationToken getAuthenticationToken(TauthInfo tauth) {
        List<GrantedAuthority> resultRoles = parseRoles(tauth);        
        return new UsernamePasswordAuthenticationToken(tauth.username, null, resultRoles);
    }
    
    
    
    private List<GrantedAuthority> parseRoles(TauthInfo tauth) {
        List<GrantedAuthority> resultRoles = new ArrayList<>();
        
		for (AuthGrRoleInfo eachAuthGrRole : tauth.authGrRoles) {
			GrantedAuthority role = new SimpleGrantedAuthority(eachAuthGrRole.codAuthRole);
			resultRoles.add(role);
		}
		
		return resultRoles;
    }
    
    
    
    private HttpServletResponse onError(HttpServletResponse res) throws IOException {
    	((HttpServletResponse) res).sendError(HttpServletResponse.SC_UNAUTHORIZED);	//TODO: melhorar resposta
    	return res;
    }
}
