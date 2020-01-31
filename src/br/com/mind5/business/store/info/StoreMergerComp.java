package br.com.mind5.business.store.info;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StoreMergerComp extends InfoMergerTemplate_<StoreInfo, CompInfo> {

	@Override protected InfoMergerVisitor_<StoreInfo, CompInfo> getVisitorHook() {
		return new StoreVisiMergeComp();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
