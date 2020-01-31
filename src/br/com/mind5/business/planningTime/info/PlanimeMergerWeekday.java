package br.com.mind5.business.planningTime.info;

import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PlanimeMergerWeekday extends InfoMergerTemplate_<PlanimeInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitor_<PlanimeInfo, WeekdayInfo> getVisitorHook() {
		return new PlanimeVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<PlanimeInfo> getUniquifierHook() {
		return new PlanimeUniquifier();
	}
}
