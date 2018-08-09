package br.com.gda.business.planningTime.info;

import java.util.List;

import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.info.InfoMerger;

final class PlanMergerME extends InfoMerger<PlanInfo, PlanInfo, MatEmpInfo> {
	public PlanInfo merge(PlanInfo sourceOne, MatEmpInfo sourceTwo) {
		return super.merge(sourceOne, sourceTwo, new PlanVisitorME());
	}
	
	
	
	public List<PlanInfo> merge(List<PlanInfo> sourceOnes, List<MatEmpInfo> sourceTwos) {
		return super.merge(sourceOnes, sourceTwos, new PlanVisitorME());
	}
}
