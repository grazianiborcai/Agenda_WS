package br.com.gda.business.planningTime.info;

import java.util.List;

import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.info.InfoMerger;

final class PlanMergerSWT extends InfoMerger<PlanInfo, PlanInfo, StoreWTimeInfo> {
	public PlanInfo merge(PlanInfo sourceOne, StoreWTimeInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PlanMergeVisitorSWT());
	}
	
	
	
	public List<PlanInfo> merge(List<PlanInfo> sourceOnes, List<StoreWTimeInfo> sourceTwos) {
		return super.write(sourceOnes, sourceTwos, new PlanMergeVisitorSWT());
	}
}
