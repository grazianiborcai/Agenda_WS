package br.com.mind5.business.store.info;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StoreMergerSotarch extends InfoMergerTemplate<StoreInfo, SotarchInfo> {

	@Override protected InfoMergerVisitor<StoreInfo, SotarchInfo> getVisitorHook() {
		return new StoreVisiMergeSotarch();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
