package br.com.gda.security.storeAuthorization.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class StorauthMergerUsername extends InfoMergerTemplate<StorauthInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<StorauthInfo, UsernameInfo> getVisitorHook() {
		return new StorauthVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<StorauthInfo> getUniquifierHook() {
		return new StorauthUniquifier();
	}
}
