package br.com.gda.business.scheduleRange.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedageMergerToSelect extends InfoMergerTemplate<SchedageInfo, SchedageInfo> {

	@Override protected InfoMergerVisitor<SchedageInfo, SchedageInfo> getVisitorHook() {
		return new SchedageVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<SchedageInfo> getUniquifierHook() {
		return new SchedageUniquifier();
	}
}
