package br.com.mind5.business.scheduleRange.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedageMergerToSelect extends InfoMergerTemplate_<SchedageInfo, SchedageInfo> {

	@Override protected InfoMergerVisitor_<SchedageInfo, SchedageInfo> getVisitorHook() {
		return new SchedageVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<SchedageInfo> getUniquifierHook() {
		return new SchedageUniquifier();
	}
}
