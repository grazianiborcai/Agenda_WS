package br.com.mind5.business.scheduleYearData.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.masterData.month.info.MonthInfo;

final class SchedyeratMergerMonth extends InfoMergerTemplate_<SchedyeratInfo, MonthInfo> {

	@Override protected InfoMergerVisitor_<SchedyeratInfo, MonthInfo> getVisitorHook() {
		return new SchedyeratVisiMergeMonth();
	}
	
	
	
	@Override protected InfoUniquifier<SchedyeratInfo> getUniquifierHook() {
		return new SchedyeratUniquifier();
	}
}
