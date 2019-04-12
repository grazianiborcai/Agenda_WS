package br.com.gda.business.planningTime.info;

import java.util.List;

import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.info.InfoMerger;

final class PlanPrunerELD extends InfoMerger<PlanInfo, PlanInfo, EmplevateInfo> {
	public PlanInfo prune(PlanInfo sourceOne, EmplevateInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PlanPruneVisitorELD());
	}
	
	
	
	public List<PlanInfo> prune(List<PlanInfo> sourceOnes, List<EmplevateInfo> sourceTwos) {
		return super.write(sourceOnes, sourceTwos, new PlanPruneVisitorELD());
	}
}//TODO: herdar de InfoPruner
