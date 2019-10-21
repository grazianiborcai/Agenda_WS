package br.com.mind5.business.scheduleYear.info;

import br.com.mind5.business.scheduleYearData.info.SchedyeratInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedyearMergerSchedyerat extends InfoMergerTemplate<SchedyearInfo, SchedyeratInfo> {

	@Override protected InfoMergerVisitor<SchedyearInfo, SchedyeratInfo> getVisitorHook() {
		return new SchedyearVisiMergeSchedyerat();
	}
	
	
	
	@Override protected InfoUniquifier<SchedyearInfo> getUniquifierHook() {
		return new SchedyearUniquifier();
	}
}
