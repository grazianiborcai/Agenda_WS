package br.com.gda.security.tokenAuthentication.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class TauthMergerUsername extends InfoMergerTemplate<TauthInfo, UsernameInfo> {

	@Override protected InfoMergerVisitorV2<TauthInfo, UsernameInfo> getVisitorHook() {
		return new TauthVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<TauthInfo> getUniquifierHook() {
		return new TauthUniquifier();
	}
}
