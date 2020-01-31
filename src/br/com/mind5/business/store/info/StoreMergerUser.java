package br.com.mind5.business.store.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.user.info.UserInfo;

final class StoreMergerUser extends InfoMergerTemplate_<StoreInfo, UserInfo> {

	@Override protected InfoMergerVisitor_<StoreInfo, UserInfo> getVisitorHook() {
		return new StoreVisiMergeUser();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
