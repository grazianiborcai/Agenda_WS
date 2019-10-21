package br.com.mind5.business.store.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.user.info.UserInfo;

final class StoreMergerUser extends InfoMergerTemplate<StoreInfo, UserInfo> {

	@Override protected InfoMergerVisitor<StoreInfo, UserInfo> getVisitorHook() {
		return new StoreVisiMergeUser();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
