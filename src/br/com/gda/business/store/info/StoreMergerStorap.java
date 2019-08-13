package br.com.gda.business.store.info;

import br.com.gda.business.storeSnapshot.info.StorapInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StoreMergerStorap extends InfoMergerTemplate<StoreInfo, StorapInfo> {

	@Override protected InfoMergerVisitor<StoreInfo, StorapInfo> getVisitorHook() {
		return new StoreVisiMergeStorap();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
