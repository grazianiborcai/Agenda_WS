package br.com.mind5.business.store.info;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StoreMergerSotarch extends InfoMergerTemplate_<StoreInfo, SotarchInfo> {

	@Override protected InfoMergerVisitor_<StoreInfo, SotarchInfo> getVisitorHook() {
		return new StoreVisiMergeSotarch();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
