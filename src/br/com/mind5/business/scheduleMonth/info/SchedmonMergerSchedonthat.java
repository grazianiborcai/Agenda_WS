package br.com.mind5.business.scheduleMonth.info;

import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedmonMergerSchedonthat extends InfoMergerTemplate_<SchedmonInfo, SchedonthatInfo> {

	@Override protected InfoMergerVisitor_<SchedmonInfo, SchedonthatInfo> getVisitorHook() {
		return new SchedmonVisiMergeSchedonthat();
	}
	
	
	
	@Override protected InfoUniquifier<SchedmonInfo> getUniquifierHook() {
		return new SchedmonUniquifier();
	}
}
