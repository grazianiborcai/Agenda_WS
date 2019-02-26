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
	private String HEADER_STRING = "Authorization";
	final String TOKEN_PREFIX = "Bearer ";

	public AuthFilterJwtoken(AuthenticationManager authenticationManager, AuthenticationEntryPoint authenticationEntryPoint) {
		super(authenticationManager, authenticationEntryPoint);
	}
	
	
	
	public AuthFilterJwtoken(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}
	
	
	
	@Override protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String header = req.getHeader(HEADER_STRING);

        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
        	((HttpServletResponse) res).sendError(HttpServletResponse.SC_UNAUTHORIZED);	//TODO: melhorar resposta
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
        
        
        if (authentication == null) {
        	((HttpServletResponse) res).sendError(HttpServletResponse.SC_UNAUTHORIZED);	//TODO: melhorar resposta
            return;
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }

	
	
    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);        
        TauthInfo tauth = jwtokenAuthentication(token);
        
        if (tauth == null)
        	return null;
        
        List<GrantedAuthority> resultRoles = extractRoles(tauth);        
        return new UsernamePasswordAuthenticationToken(tauth.username, null, resultRoles);
    }
    
    
    
    private TauthInfo jwtokenAuthentication(String token) {
    	if (token == null)
    		return null;
    	
    	TauthInfo tauth = new TauthInfo();
    	tauth.tokenToVerify = token;
    	
    	DeciTree<TauthInfo> authenticator = new AuthJwtoken(tauth);
    	authenticator.makeDecision();
    	
    	DeciResult<TauthInfo> result = authenticator.getDecisionResult();
    	
    	if (result.isSuccess() == false)
    		return null;
    	
    	if (result.hasResultset() == false)
    		return null;
    	
    	return result.getResultset().get(0);
    }
    
    
    
    private List<GrantedAuthority> extractRoles(TauthInfo tauth) {
        List<GrantedAuthority> resultRoles = new ArrayList<>();
        
		for (AuthGrRoleInfo eachAuthGrRole : tauth.authGrRoles) {
			GrantedAuthority role = new SimpleGrantedAuthority(eachAuthGrRole.codAuthRole);
			resultRoles.add(role);
		}
		
		return resultRoles;
    }
}
