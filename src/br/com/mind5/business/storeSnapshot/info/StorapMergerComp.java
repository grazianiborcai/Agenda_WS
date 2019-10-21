package br.com.mind5.business.storeSnapshot.info;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StorapMergerComp extends InfoMergerTemplate<StorapInfo, CompInfo> {

	@Override protected InfoMergerVisitor<StorapInfo, CompInfo> getVisitorHook() {
		return new StorapVisiMergeComp();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StorapUniquifier();
	}
}
