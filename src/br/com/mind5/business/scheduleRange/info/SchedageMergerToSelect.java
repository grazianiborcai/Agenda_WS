package br.com.mind5.business.scheduleRange.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedageMergerToSelect extends InfoMergerTemplate<SchedageInfo, SchedageInfo> {

	@Override protected InfoMergerVisitor<SchedageInfo, SchedageInfo> getVisitorHook() {
		return new SchedageVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<SchedageInfo> getUniquifierHook() {
		return new SchedageUniquifier();
	}
}
