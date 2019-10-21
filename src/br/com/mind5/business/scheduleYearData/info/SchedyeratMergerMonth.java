package br.com.mind5.business.scheduleYearData.info;

import br.com.mind5.business.masterData.info.MonthInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedyeratMergerMonth extends InfoMergerTemplate<SchedyeratInfo, MonthInfo> {

	@Override protected InfoMergerVisitor<SchedyeratInfo, MonthInfo> getVisitorHook() {
		return new SchedyeratVisiMergeMonth();
	}
	
	
	
	@Override protected InfoUniquifier<SchedyeratInfo> getUniquifierHook() {
		return new SchedyeratUniquifier();
	}
}
