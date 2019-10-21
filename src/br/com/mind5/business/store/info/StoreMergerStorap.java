package br.com.mind5.business.store.info;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StoreMergerStorap extends InfoMergerTemplate<StoreInfo, StorapInfo> {

	@Override protected InfoMergerVisitor<StoreInfo, StorapInfo> getVisitorHook() {
		return new StoreVisiMergeStorap();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
