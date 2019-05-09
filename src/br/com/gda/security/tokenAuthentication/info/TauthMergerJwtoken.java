package br.com.gda.security.tokenAuthentication.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.jwtToken.info.JwtokenInfo;

final class TauthMergerJwtoken extends InfoMergerTemplate<TauthInfo, JwtokenInfo> {

	@Override protected InfoMergerVisitorV2<TauthInfo, JwtokenInfo> getVisitorHook() {
		return new TauthVisiMergeJwtoken();
	}
	
	
	
	@Override protected InfoUniquifier<TauthInfo> getUniquifierHook() {
		return new TauthUniquifier();
	}
}
