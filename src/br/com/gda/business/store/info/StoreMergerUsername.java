package br.com.gda.business.store.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class StoreMergerUsername extends InfoMergerTemplate<StoreInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<StoreInfo, UsernameInfo> getVisitorHook() {
		return new StoreVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
