package br.com.gda.business.store.info;

import br.com.gda.business.storeSearch.info.SotarchInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StoreMergerSotarch extends InfoMergerTemplate<StoreInfo, SotarchInfo> {

	@Override protected InfoMergerVisitor<StoreInfo, SotarchInfo> getVisitorHook() {
		return new StoreVisiMergeSotarch();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
