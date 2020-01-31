package br.com.mind5.security.storeAuthorization.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

final class StorauthMergerUsername extends InfoMergerTemplate_<StorauthInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor_<StorauthInfo, UsernameInfo> getVisitorHook() {
		return new StorauthVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<StorauthInfo> getUniquifierHook() {
		return new StorauthUniquifier();
	}
}
