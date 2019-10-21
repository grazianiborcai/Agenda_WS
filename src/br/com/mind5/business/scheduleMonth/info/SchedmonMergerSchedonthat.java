package br.com.mind5.business.scheduleMonth.info;

import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedmonMergerSchedonthat extends InfoMergerTemplate<SchedmonInfo, SchedonthatInfo> {

	@Override protected InfoMergerVisitor<SchedmonInfo, SchedonthatInfo> getVisitorHook() {
		return new SchedmonVisiMergeSchedonthat();
	}
	
	
	
	@Override protected InfoUniquifier<SchedmonInfo> getUniquifierHook() {
		return new SchedmonUniquifier();
	}
}
