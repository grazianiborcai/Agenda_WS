package br.com.mind5.security.tokenAuthentication.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;

final class TauthMergerJwtoken extends InfoMergerTemplate<TauthInfo, JwtokenInfo> {

	@Override protected InfoMergerVisitor<TauthInfo, JwtokenInfo> getVisitorHook() {
		return new TauthVisiMergeJwtoken();
	}
	
	
	
	@Override protected InfoUniquifier<TauthInfo> getUniquifierHook() {
		return new TauthUniquifier();
	}
}
