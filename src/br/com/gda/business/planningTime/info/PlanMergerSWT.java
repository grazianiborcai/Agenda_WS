package br.com.gda.business.planningTime.info;

import java.util.List;

import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.info.InfoMerger;

final class PlanMergerSWT extends InfoMerger<PlanInfo, PlanInfo, StowotmInfo> {
	public PlanInfo merge(PlanInfo sourceOne, StowotmInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PlanMergeVisitorSWT());
	}
	
	
	
	public List<PlanInfo> merge(List<PlanInfo> sourceOnes, List<StowotmInfo> sourceTwos) {
		return super.write(sourceOnes, sourceTwos, new PlanMergeVisitorSWT());
	}
}
