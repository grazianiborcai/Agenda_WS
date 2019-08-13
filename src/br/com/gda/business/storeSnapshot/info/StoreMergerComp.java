package br.com.gda.business.storeSnapshot.info;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StoreMergerComp extends InfoMergerTemplate<StorapInfo, CompInfo> {

	@Override protected InfoMergerVisitor<StorapInfo, CompInfo> getVisitorHook() {
		return new StoreVisiMergeComp();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
