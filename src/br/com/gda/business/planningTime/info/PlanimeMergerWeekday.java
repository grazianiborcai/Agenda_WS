package br.com.gda.business.planningTime.info;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class PlanimeMergerWeekday extends InfoMergerTemplate<PlanimeInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitorV2<PlanimeInfo, WeekdayInfo> getVisitorHook() {
		return new PlanimeVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<PlanimeInfo> getUniquifierHook() {
		return new PlanimeUniquifier();
	}
}
