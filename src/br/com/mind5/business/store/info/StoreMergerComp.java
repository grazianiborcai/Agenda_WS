package br.com.mind5.business.store.info;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StoreMergerComp extends InfoMergerTemplate<StoreInfo, CompInfo> {

	@Override protected InfoMergerVisitor<StoreInfo, CompInfo> getVisitorHook() {
		return new StoreVisiMergeComp();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
