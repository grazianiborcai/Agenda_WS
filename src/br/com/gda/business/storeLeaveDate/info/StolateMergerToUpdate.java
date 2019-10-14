package br.com.gda.business.storeLeaveDate.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StolateMergerToUpdate extends InfoMergerTemplate<StolateInfo, StolateInfo> {

	@Override protected InfoMergerVisitor<StolateInfo, StolateInfo> getVisitorHook() {
		return new StolateVisiMergeToUpdate();
	}
	
	
	
	@Override protected InfoUniquifier<StolateInfo> getUniquifierHook() {
		return new StolateUniquifier();
	}
}
