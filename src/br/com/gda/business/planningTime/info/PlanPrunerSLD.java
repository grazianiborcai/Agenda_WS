package br.com.gda.business.planningTime.info;

import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.info.InfoMerger_;

final class PlanPrunerSLD extends InfoMerger_<PlanInfo, PlanInfo, StolevateInfo> {
	public PlanInfo prune(PlanInfo sourceOne, StolevateInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PlanPruneVisitorSLD());
	}
	
	
	
	public List<PlanInfo> prune(List<PlanInfo> sourceOnes, List<StolevateInfo> sourceTwos) {
		return super.write(sourceOnes, sourceTwos, new PlanPruneVisitorSLD());
	}
}//TODO: herdar de InfoPruner
