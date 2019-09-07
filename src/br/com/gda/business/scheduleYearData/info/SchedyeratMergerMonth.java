package br.com.gda.business.scheduleYearData.info;

import br.com.gda.business.masterData.info.MonthInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedyeratMergerMonth extends InfoMergerTemplate<SchedyeratInfo, MonthInfo> {

	@Override protected InfoMergerVisitor<SchedyeratInfo, MonthInfo> getVisitorHook() {
		return new SchedyeratVisiMergeMonth();
	}
	
	
	
	@Override protected InfoUniquifier<SchedyeratInfo> getUniquifierHook() {
		return new SchedyeratUniquifier();
	}
}
