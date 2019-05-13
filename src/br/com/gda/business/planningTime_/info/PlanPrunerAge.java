package br.com.gda.business.planningTime_.info;

import java.util.List;

import br.com.gda.business.age_.info.AgeInfo;
import br.com.gda.info.obsolete.InfoPruner_;

final class PlanPrunerAge extends InfoPruner_<PlanInfo, AgeInfo> {
	public PlanInfo prune(PlanInfo sourceOne, AgeInfo sourceTwo) {
		return super.prune(sourceOne, sourceTwo, new PlanPruneVisitorAge());
	}
	
	
	
	public List<PlanInfo> prune(List<PlanInfo> sourceOnes, List<AgeInfo> sourceTwos) {
		return super.prune(sourceOnes, sourceTwos, new PlanPruneVisitorAge());
	}
}
