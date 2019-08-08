package br.com.gda.business.store.info;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StoreMergerComp extends InfoMergerTemplate<StoreInfo, CompInfo> {

	@Override protected InfoMergerVisitor<StoreInfo, CompInfo> getVisitorHook() {
		return new StoreVisiMergeComp();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
