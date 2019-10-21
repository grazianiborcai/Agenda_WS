package br.com.mind5.business.planningTime.info;

import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class PlanimeMergerWeekday extends InfoMergerTemplate<PlanimeInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitor<PlanimeInfo, WeekdayInfo> getVisitorHook() {
		return new PlanimeVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<PlanimeInfo> getUniquifierHook() {
		return new PlanimeUniquifier();
	}
}
