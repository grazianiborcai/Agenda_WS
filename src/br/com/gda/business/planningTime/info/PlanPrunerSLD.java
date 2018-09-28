package br.com.gda.business.planningTime.info;

import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StoreLDateInfo;
import br.com.gda.info.InfoMerger;

final class PlanPrunerSLD extends InfoMerger<PlanInfo, PlanInfo, StoreLDateInfo> {
	public PlanInfo prune(PlanInfo sourceOne, StoreLDateInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PlanPruneVisitorSLD());
	}
	
	
	
	public List<PlanInfo> prune(List<PlanInfo> sourceOnes, List<StoreLDateInfo> sourceTwos) {
		return super.write(sourceOnes, sourceTwos, new PlanPruneVisitorSLD());
	}
}//TODO: herdar de InfoPruner
