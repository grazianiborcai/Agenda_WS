package br.com.gda.business.storeLeaveDate.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class StolevateMergerToSelect extends InfoMergerTemplate<StolevateInfo, StolevateInfo> {

	@Override protected InfoMergerVisitorV2<StolevateInfo, StolevateInfo> getVisitorHook() {
		return new StolevateVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StolevateInfo> getUniquifierHook() {
		return new StolevateUniquifier();
	}
}
