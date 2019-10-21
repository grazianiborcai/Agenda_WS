package br.com.mind5.business.scheduleYearData.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedyeratMergerToSelect extends InfoMergerTemplate<SchedyeratInfo, SchedyeratInfo> {

	@Override protected InfoMergerVisitor<SchedyeratInfo, SchedyeratInfo> getVisitorHook() {
		return new SchedyeratVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<SchedyeratInfo> getUniquifierHook() {
		return new SchedyeratUniquifier();
	}
}
