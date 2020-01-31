package br.com.mind5.security.storeAuthorization.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StorauthMergerToSelect extends InfoMergerTemplate_<StorauthInfo, StorauthInfo> {

	@Override protected InfoMergerVisitor_<StorauthInfo, StorauthInfo> getVisitorHook() {
		return new StorauthVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StorauthInfo> getUniquifierHook() {
		return new StorauthUniquifier();
	}
}
