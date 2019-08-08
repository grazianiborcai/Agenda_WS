package br.com.gda.business.store.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.user.info.UserInfo;

final class StoreMergerUser extends InfoMergerTemplate<StoreInfo, UserInfo> {

	@Override protected InfoMergerVisitor<StoreInfo, UserInfo> getVisitorHook() {
		return new StoreVisiMergeUser();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
