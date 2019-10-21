package br.com.mind5.security.tokenAuthentication.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class TauthMergerUsername extends InfoMergerTemplate<TauthInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<TauthInfo, UsernameInfo> getVisitorHook() {
		return new TauthVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<TauthInfo> getUniquifierHook() {
		return new TauthUniquifier();
	}
}
