package br.com.gda.business.planningTime_.info;

import java.util.List;

import br.com.gda.business.age.info.AgeInfo;
import br.com.gda.info.InfoPruner;

final class PlanPrunerAge extends InfoPruner<PlanInfo, AgeInfo> {
	public PlanInfo prune(PlanInfo sourceOne, AgeInfo sourceTwo) {
		return super.prune(sourceOne, sourceTwo, new PlanPruneVisitorAge());
	}
	
	
	
	public List<PlanInfo> prune(List<PlanInfo> sourceOnes, List<AgeInfo> sourceTwos) {
		return super.prune(sourceOnes, sourceTwos, new PlanPruneVisitorAge());
	}
}
