package br.com.gda.business.scheduleYearData.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedyeratMergerToSelect extends InfoMergerTemplate<SchedyeratInfo, SchedyeratInfo> {

	@Override protected InfoMergerVisitor<SchedyeratInfo, SchedyeratInfo> getVisitorHook() {
		return new SchedyeratVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<SchedyeratInfo> getUniquifierHook() {
		return new SchedyeratUniquifier();
	}
}
