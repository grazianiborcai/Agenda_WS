package br.com.gda.business.planningTime.info;

import java.util.List;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.info.InfoMerger;

final class PlanMergerWeekday extends InfoMerger<PlanInfo, PlanInfo, WeekdayInfo> {
	public PlanInfo merge(PlanInfo sourceOne, WeekdayInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PlanMergeVisitorWeekday());
	}
	
	
	
	public List<PlanInfo> merge(List<PlanInfo> sourceOnes, List<WeekdayInfo> sourceTwos) {
		return super.write(sourceOnes, sourceTwos, new PlanMergeVisitorWeekday());
	}
}
