package br.com.mind5.business.storeSnapshot.info;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StorapMergerComp extends InfoMergerTemplate_<StorapInfo, CompInfo> {

	@Override protected InfoMergerVisitor_<StorapInfo, CompInfo> getVisitorHook() {
		return new StorapVisiMergeComp();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StorapUniquifier();
	}
}
