package br.com.mind5.business.materialStoreSnapshot.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatorapMergerToSelect extends InfoMergerTemplate<MatorapInfo, MatorapInfo> {

	@Override protected InfoMergerVisitor<MatorapInfo, MatorapInfo> getVisitorHook() {
		return new MatorapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<MatorapInfo> getUniquifierHook() {
		return new MatorapUniquifier();
	}	
}
