package br.com.mind5.business.store.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StoreMergerToSelect extends InfoMergerTemplate<StoreInfo, StoreInfo> {

	@Override protected InfoMergerVisitor<StoreInfo, StoreInfo> getVisitorHook() {
		return new StoreVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
