package br.com.mind5.security.tokenAuthentication.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;

final class TauthMergerJwtoken extends InfoMergerTemplate_<TauthInfo, JwtokenInfo> {

	@Override protected InfoMergerVisitor_<TauthInfo, JwtokenInfo> getVisitorHook() {
		return new TauthVisiMergeJwtoken();
	}
	
	
	
	@Override protected InfoUniquifier<TauthInfo> getUniquifierHook() {
		return new TauthUniquifier();
	}
}
