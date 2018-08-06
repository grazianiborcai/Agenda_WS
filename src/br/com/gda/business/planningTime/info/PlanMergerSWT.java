package br.com.gda.business.planningTime.info;

import java.util.List;

import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.info.RecordMerger;

final class PlanMergerSWT extends RecordMerger<PlanInfo, PlanInfo, StoreWTimeInfo> {
	public PlanInfo merge(PlanInfo sourceOne, StoreWTimeInfo sourceTwo) {
		return super.merge(sourceOne, sourceTwo, new PlanVisitorSWT());
	}
	
	
	
	public List<PlanInfo> merge(List<PlanInfo> sourceOnes, List<StoreWTimeInfo> sourceTwos) {
		return super.merge(sourceOnes, sourceTwos, new PlanVisitorSWT());
	}
}
