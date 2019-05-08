package br.com.gda.business.store.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class StoreMergerToSelect extends InfoMergerTemplate<StoreInfo, StoreInfo> {

	@Override protected InfoMergerVisitorV2<StoreInfo, StoreInfo> getVisitorHook() {
		return new StoreVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
