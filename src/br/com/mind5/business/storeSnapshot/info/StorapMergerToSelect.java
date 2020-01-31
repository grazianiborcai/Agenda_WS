package br.com.mind5.business.storeSnapshot.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StorapMergerToSelect extends InfoMergerTemplate_<StorapInfo, StorapInfo> {

	@Override protected InfoMergerVisitor_<StorapInfo, StorapInfo> getVisitorHook() {
		return new StorapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StorapUniquifier();
	}
}
