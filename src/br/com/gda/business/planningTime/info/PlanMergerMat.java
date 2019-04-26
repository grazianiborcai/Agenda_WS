package br.com.gda.business.planningTime.info;

import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoMerger_;

final class PlanMergerMat extends InfoMerger_<PlanInfo, PlanInfo, MatInfo> {
	public PlanInfo merge(PlanInfo sourceOne, MatInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PlanMergeVisitorMat());
	}
	
	
	
	public List<PlanInfo> merge(List<PlanInfo> sourceOnes, List<MatInfo> sourceTwos) {
		return super.write(sourceOnes, sourceTwos, new PlanMergeVisitorMat());
	}
}
