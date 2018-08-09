package br.com.gda.business.planningTime.info;

import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoMerger;

final class PlanMergerMat extends InfoMerger<PlanInfo, PlanInfo, MatInfo> {
	public PlanInfo merge(PlanInfo sourceOne, MatInfo sourceTwo) {
		return super.merge(sourceOne, sourceTwo, new PlanVisitorMat());
	}
	
	
	
	public List<PlanInfo> merge(List<PlanInfo> sourceOnes, List<MatInfo> sourceTwos) {
		return super.merge(sourceOnes, sourceTwos, new PlanVisitorMat());
	}
}
