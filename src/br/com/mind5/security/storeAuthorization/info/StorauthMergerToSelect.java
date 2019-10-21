package br.com.mind5.security.storeAuthorization.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StorauthMergerToSelect extends InfoMergerTemplate<StorauthInfo, StorauthInfo> {

	@Override protected InfoMergerVisitor<StorauthInfo, StorauthInfo> getVisitorHook() {
		return new StorauthVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StorauthInfo> getUniquifierHook() {
		return new StorauthUniquifier();
	}
}
