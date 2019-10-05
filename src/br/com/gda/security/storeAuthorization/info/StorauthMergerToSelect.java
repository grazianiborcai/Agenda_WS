package br.com.gda.security.storeAuthorization.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StorauthMergerToSelect extends InfoMergerTemplate<StorauthInfo, StorauthInfo> {

	@Override protected InfoMergerVisitor<StorauthInfo, StorauthInfo> getVisitorHook() {
		return new StorauthVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StorauthInfo> getUniquifierHook() {
		return new StorauthUniquifier();
	}
}
