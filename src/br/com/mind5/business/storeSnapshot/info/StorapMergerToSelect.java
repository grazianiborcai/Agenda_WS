package br.com.mind5.business.storeSnapshot.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StorapMergerToSelect extends InfoMergerTemplate<StorapInfo, StorapInfo> {

	@Override protected InfoMergerVisitor<StorapInfo, StorapInfo> getVisitorHook() {
		return new StorapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StorapUniquifier();
	}
}
