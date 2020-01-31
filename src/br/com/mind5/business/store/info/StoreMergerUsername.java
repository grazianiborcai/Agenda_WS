package br.com.mind5.business.store.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

final class StoreMergerUsername extends InfoMergerTemplate_<StoreInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor_<StoreInfo, UsernameInfo> getVisitorHook() {
		return new StoreVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
