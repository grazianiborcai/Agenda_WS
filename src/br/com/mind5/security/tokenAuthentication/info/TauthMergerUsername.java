package br.com.mind5.security.tokenAuthentication.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

final class TauthMergerUsername extends InfoMergerTemplate_<TauthInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor_<TauthInfo, UsernameInfo> getVisitorHook() {
		return new TauthVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<TauthInfo> getUniquifierHook() {
		return new TauthUniquifier();
	}
}
