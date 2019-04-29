package br.com.gda.business.store.info;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class StoreMergerUser extends InfoMergerTemplate<StoreInfo, UserInfo> {

	@Override protected InfoMergerVisitorV2<StoreInfo, UserInfo> getVisitorHook() {
		return new StoreVisiMergeUser();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
