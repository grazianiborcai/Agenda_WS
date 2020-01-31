package br.com.mind5.business.store.info;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StoreMergerStorap extends InfoMergerTemplate_<StoreInfo, StorapInfo> {

	@Override protected InfoMergerVisitor_<StoreInfo, StorapInfo> getVisitorHook() {
		return new StoreVisiMergeStorap();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
