package br.com.mind5.servlet.filter.authentication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.mind5.masterData.authorizationGroupRole.info.AuthgroleInfo;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.security.userAuthentication.info.UauthInfo;

public final class AuthProviderPwrd implements AuthenticationProvider {
	
	@Override public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		AuthToken token = (AuthToken) authentication;
		
        List<GrantedAuthority> roles = authUser(token);                
        return new UsernamePasswordAuthenticationToken(token.getName(), token.getName(), roles);
	}
	
	
	
	private List<GrantedAuthority> authUser(AuthToken token) throws AuthenticationException {
		UauthInfo recordInfo = makeRecordInfo(token);
		DeciTree<UauthInfo> authenticator = new AuthPwrd(recordInfo);
		
		authenticator.makeDecision();		
		checkResult(authenticator.getDecisionResult());
		
		List<GrantedAuthority> results = parseRoles(authenticator.getDecisionResult().getResultset());
		authenticator.close();
		return results;
	}
	
	
	
	private UauthInfo makeRecordInfo(AuthToken token) {
		UauthInfo recordInfo = new UauthInfo();
		
		recordInfo.codOwner = token.getCodOwner();
		recordInfo.username = token.getName();
		recordInfo.password = token.getCredentials().toString();
		recordInfo.codLanguage = token.getCodLanguage();
		
		//System.out.println(recordInfo.codOwner + " - " + recordInfo.username + " - " + recordInfo.password + " - " + recordInfo.codLanguage);
		
		return recordInfo;
	}
	
	
	
	private void checkResult(DeciResult<UauthInfo> treeResult) throws AuthenticationException {
		if (treeResult.isSuccess() == false)
			onError();
		
		
		if (treeResult.hasResultset() == false)
			onError();
	}
	
	
	
	private void onError() throws AuthenticationException {
		throw new AuthenticationCredentialsNotFoundException("Invalid Credentials!");	//TODO: melhorar mensagem
	}
	
	
	
	private List<GrantedAuthority> parseRoles(List<UauthInfo> resultSets) throws AuthenticationException {
		List<GrantedAuthority> resultRoles = new ArrayList<>();
		
		for (UauthInfo eachSet : resultSets) {
			for (AuthgroleInfo eachAuthgrole : eachSet.authgroles) {
				GrantedAuthority role = new SimpleGrantedAuthority(eachAuthgrole.codAuthRole);
				resultRoles.add(role);
			}
		}
		
		return resultRoles;
	}

	
	
	@Override public boolean supports(Class<?> authentication) {
		return authentication.equals(AuthToken.class);
	}
}
