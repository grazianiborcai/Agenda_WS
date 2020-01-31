package br.com.mind5.business.store.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StoreMergerToUpdate extends InfoMergerTemplate_<StoreInfo, StoreInfo> {

	@Override protected InfoMergerVisitor_<StoreInfo, StoreInfo> getVisitorHook() {
		return new StoreVisiMergeToUpdate();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
