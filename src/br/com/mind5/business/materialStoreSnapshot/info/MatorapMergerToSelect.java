package br.com.mind5.business.materialStoreSnapshot.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatorapMergerToSelect extends InfoMergerTemplate_<MatorapInfo, MatorapInfo> {

	@Override protected InfoMergerVisitor_<MatorapInfo, MatorapInfo> getVisitorHook() {
		return new MatorapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<MatorapInfo> getUniquifierHook() {
		return new MatorapUniquifier();
	}	
}
