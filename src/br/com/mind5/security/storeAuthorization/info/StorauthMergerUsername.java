package br.com.mind5.security.storeAuthorization.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class StorauthMergerUsername extends InfoMergerTemplate<StorauthInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<StorauthInfo, UsernameInfo> getVisitorHook() {
		return new StorauthVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<StorauthInfo> getUniquifierHook() {
		return new StorauthUniquifier();
	}
}
