package br.com.gda.business.storeSnapshot.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StoreMergerToSelect extends InfoMergerTemplate<StorapInfo, StorapInfo> {

	@Override protected InfoMergerVisitor<StorapInfo, StorapInfo> getVisitorHook() {
		return new StoreVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
