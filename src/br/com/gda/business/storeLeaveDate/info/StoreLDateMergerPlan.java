package br.com.gda.business.storeLeaveDate.info;

import java.util.List;

import br.com.gda.business.planningTime.info.PlanDataInfo;
import br.com.gda.info.InfoMerger;

final class StoreLDateMergerPlan extends InfoMerger<StoreLDateInfo, PlanDataInfo, StoreLDateInfo> {
	public StoreLDateInfo merge(PlanDataInfo sourceOne, StoreLDateInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new StoreLDateVisitorPlan());
	}
	
	
	
	public List<StoreLDateInfo> merge(List<PlanDataInfo> sourceOnes, List<StoreLDateInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new StoreLDateVisitorPlan());
	}
}
