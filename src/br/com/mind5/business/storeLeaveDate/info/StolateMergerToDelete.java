package br.com.mind5.business.storeLeaveDate.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StolateMergerToDelete extends InfoMergerTemplate_<StolateInfo, StolateInfo> {

	@Override protected InfoMergerVisitor_<StolateInfo, StolateInfo> getVisitorHook() {
		return new StolateVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<StolateInfo> getUniquifierHook() {
		return new StolateUniquifier();
	}
}
