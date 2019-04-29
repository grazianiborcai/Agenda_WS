package br.com.gda.business.planningTime_.info;

import java.util.List;

import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.info.InfoMerger_;

final class PlanMergerSWT_ extends InfoMerger_<PlanInfo, PlanInfo, StowotmInfo> {
	public PlanInfo merge(PlanInfo sourceOne, StowotmInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PlanVisiMergeStowotm_());
	}
	
	
	
	public List<PlanInfo> merge(List<PlanInfo> sourceOnes, List<StowotmInfo> sourceTwos) {
		return super.write(sourceOnes, sourceTwos, new PlanVisiMergeStowotm_());
	}
}
