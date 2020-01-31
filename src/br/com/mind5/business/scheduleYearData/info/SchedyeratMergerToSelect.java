package br.com.mind5.business.scheduleYearData.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedyeratMergerToSelect extends InfoMergerTemplate_<SchedyeratInfo, SchedyeratInfo> {

	@Override protected InfoMergerVisitor_<SchedyeratInfo, SchedyeratInfo> getVisitorHook() {
		return new SchedyeratVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<SchedyeratInfo> getUniquifierHook() {
		return new SchedyeratUniquifier();
	}
}
