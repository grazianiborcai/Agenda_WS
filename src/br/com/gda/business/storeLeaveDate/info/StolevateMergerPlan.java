package br.com.gda.business.storeLeaveDate.info;

import java.util.List;

import br.com.gda.business.planningTime.info.PlanDataInfo;
import br.com.gda.info.InfoMerger_;

final class StolevateMergerPlan extends InfoMerger_<StolevateInfo, PlanDataInfo, StolevateInfo> {
	public StolevateInfo merge(PlanDataInfo sourceOne, StolevateInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new StolevateVisiMergePlan());
	}
	
	
	
	public List<StolevateInfo> merge(List<PlanDataInfo> sourceOnes, List<StolevateInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new StolevateVisiMergePlan());
	}
}
