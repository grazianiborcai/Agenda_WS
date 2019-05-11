package br.com.gda.business.planningTime_.info;

import java.util.List;

import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class PlanPrunerELD extends InfoMerger_<PlanInfo, PlanInfo, EmplevateInfo> {
	public PlanInfo prune(PlanInfo sourceOne, EmplevateInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PlanPruneVisitorELD());
	}
	
	
	
	public List<PlanInfo> prune(List<PlanInfo> sourceOnes, List<EmplevateInfo> sourceTwos) {
		return super.write(sourceOnes, sourceTwos, new PlanPruneVisitorELD());
	}
}//TODO: herdar de InfoPruner
