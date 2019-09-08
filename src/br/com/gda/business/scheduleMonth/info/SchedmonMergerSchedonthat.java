package br.com.gda.business.scheduleMonth.info;

import br.com.gda.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedmonMergerSchedonthat extends InfoMergerTemplate<SchedmonInfo, SchedonthatInfo> {

	@Override protected InfoMergerVisitor<SchedmonInfo, SchedonthatInfo> getVisitorHook() {
		return new SchedmonVisiMergeSchedonthat();
	}
	
	
	
	@Override protected InfoUniquifier<SchedmonInfo> getUniquifierHook() {
		return new SchedmonUniquifier();
	}
}
