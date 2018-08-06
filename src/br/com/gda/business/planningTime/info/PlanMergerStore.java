package br.com.gda.business.planningTime.info;

import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.info.RecordMerger;

final class PlanMergerStore extends RecordMerger<PlanInfo, PlanInfo, StoreInfo> {
	public PlanInfo merge(PlanInfo sourceOne, StoreInfo sourceTwo) {
		return super.merge(sourceOne, sourceTwo, new PlanVisitorStore());
	}
	
	
	
	public List<PlanInfo> merge(List<PlanInfo> sourceOnes, List<StoreInfo> sourceTwos) {
		return super.merge(sourceOnes, sourceTwos, new PlanVisitorStore());
	}
}
