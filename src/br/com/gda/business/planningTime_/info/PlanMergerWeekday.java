package br.com.gda.business.planningTime_.info;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class PlanMergerWeekday extends InfoMergerTemplate<PlanInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitorV2<PlanInfo, WeekdayInfo> getVisitorHook() {
		return new PlanVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<PlanInfo> getUniquifierHook() {
		return new PlanUniquifier();
	}
}
