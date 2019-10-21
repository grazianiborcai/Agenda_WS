package br.com.mind5.business.storeLeaveDate.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StolateMergerToSelect extends InfoMergerTemplate<StolateInfo, StolateInfo> {

	@Override protected InfoMergerVisitor<StolateInfo, StolateInfo> getVisitorHook() {
		return new StolateVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StolateInfo> getUniquifierHook() {
		return new StolateUniquifier();
	}
}
