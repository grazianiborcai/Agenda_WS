package br.com.gda.business.scheduleYear.info;

import br.com.gda.business.scheduleYearData.info.SchedyeratInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedyearMergerSchedyerat extends InfoMergerTemplate<SchedyearInfo, SchedyeratInfo> {

	@Override protected InfoMergerVisitor<SchedyearInfo, SchedyeratInfo> getVisitorHook() {
		return new SchedyearVisiMergeSchedyerat();
	}
	
	
	
	@Override protected InfoUniquifier<SchedyearInfo> getUniquifierHook() {
		return new SchedyearUniquifier();
	}
}
