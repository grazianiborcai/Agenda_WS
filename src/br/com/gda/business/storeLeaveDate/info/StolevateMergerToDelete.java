package br.com.gda.business.storeLeaveDate.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StolevateMergerToDelete extends InfoMergerTemplate<StolevateInfo, StolevateInfo> {

	@Override protected InfoMergerVisitor<StolevateInfo, StolevateInfo> getVisitorHook() {
		return new StolevateVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<StolevateInfo> getUniquifierHook() {
		return new StolevateUniquifier();
	}
}
