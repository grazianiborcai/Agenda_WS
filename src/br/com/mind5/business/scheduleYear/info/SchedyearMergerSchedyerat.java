package br.com.mind5.business.scheduleYear.info;

import br.com.mind5.business.scheduleYearData.info.SchedyeratInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedyearMergerSchedyerat extends InfoMergerTemplate_<SchedyearInfo, SchedyeratInfo> {

	@Override protected InfoMergerVisitor_<SchedyearInfo, SchedyeratInfo> getVisitorHook() {
		return new SchedyearVisiMergeSchedyerat();
	}
	
	
	
	@Override protected InfoUniquifier<SchedyearInfo> getUniquifierHook() {
		return new SchedyearUniquifier();
	}
}
