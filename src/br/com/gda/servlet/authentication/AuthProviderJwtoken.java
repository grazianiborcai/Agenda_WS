package br.com.gda.servlet.authentication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.gda.business.masterData.info.AuthGrRoleInfo;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.tokenAuthentication.info.TauthInfo;
import br.com.gda.security.userAuthentication.info.UauthInfo;

public final class AuthProviderJwtoken implements AuthenticationProvider {
	
	@Override public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		AuthToken token = (AuthToken) authentication;
		
        List<GrantedAuthority> roles = authUser(token);        
        return new UsernamePasswordAuthenticationToken(token.getName(), token.getName(), roles);
	}
	
	
	
	private List<GrantedAuthority> authUser(AuthToken token) {
		TauthInfo recordInfo = makeRecordInfo(token);
		DeciTree<TauthInfo> deciTree = new AuthJwtoken(recordInfo);
		
		deciTree.makeDecision();		
		return extractRoles(deciTree.getDecisionResult());
	}
	
	
	
	private TauthInfo makeRecordInfo(AuthToken token) {
		TauthInfo recordInfo = new TauthInfo();
		recordInfo.codOwner = token.getCodOwner();
		recordInfo.username = token.getName();
		recordInfo.password = token.getCredentials().toString();
		recordInfo.codLanguage = token.getCodLanguage();
		
		return recordInfo;
	}
	
	
	
	private List<GrantedAuthority> extractRoles(DeciResult<UauthInfo> treeResult) {
		if (treeResult.isSuccess() == false)
			return null;
		
		
		if (treeResult.hasResultset() == false)
			return null;
		
		
		List<UauthInfo> resultSets = treeResult.getResultset();
		List<GrantedAuthority> resultRoles = new ArrayList<>();
		
		for (UauthInfo eachSet : resultSets) {
			for (AuthGrRoleInfo eachAuthGrRole : eachSet.authGrRoles) {
				GrantedAuthority role = new SimpleGrantedAuthority(eachAuthGrRole.codAuthRole);
				resultRoles.add(role);
			}
		}
		
		return resultRoles;
	}

	
	
	@Override public boolean supports(Class<?> authentication) {
		return authentication.equals(AuthToken.class);
	}
}
