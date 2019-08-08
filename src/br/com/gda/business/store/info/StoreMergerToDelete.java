package br.com.gda.business.store.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StoreMergerToDelete extends InfoMergerTemplate<StoreInfo, StoreInfo> {

	@Override protected InfoMergerVisitor<StoreInfo, StoreInfo> getVisitorHook() {
		return new StoreVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
