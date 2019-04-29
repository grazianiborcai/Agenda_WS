package br.com.gda.business.planningTime_.info;

import java.util.List;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.info.InfoMerger_;

final class PlanMergerWeekday_ extends InfoMerger_<PlanInfo, PlanInfo, WeekdayInfo> {
	public PlanInfo merge(PlanInfo sourceOne, WeekdayInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PlanVisiMergeWeekday_());
	}
	
	
	
	public List<PlanInfo> merge(List<PlanInfo> sourceOnes, List<WeekdayInfo> sourceTwos) {
		return super.write(sourceOnes, sourceTwos, new PlanVisiMergeWeekday_());
	}
}
