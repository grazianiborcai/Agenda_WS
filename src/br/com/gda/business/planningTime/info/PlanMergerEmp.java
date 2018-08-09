package br.com.gda.business.planningTime.info;

import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.info.InfoMerger;

final class PlanMergerEmp extends InfoMerger<PlanInfo, PlanInfo, EmpInfo> {
	public PlanInfo merge(PlanInfo sourceOne, EmpInfo sourceTwo) {
		return super.merge(sourceOne, sourceTwo, new PlanVisitorEmp());
	}
	
	
	
	public List<PlanInfo> merge(List<PlanInfo> sourceOnes, List<EmpInfo> sourceTwos) {
		return super.merge(sourceOnes, sourceTwos, new PlanVisitorEmp());
	}
}
