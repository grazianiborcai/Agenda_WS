package br.com.gda.business.planningTime.info;

import java.util.List;

import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.info.InfoMerger;

final class PlanMergerEWT extends InfoMerger<PlanInfo, PlanInfo, EmpWTimeInfo> {
	public PlanInfo merge(PlanInfo sourceOne, EmpWTimeInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PlanMergeVisitorEWT());
	}
	
	
	
	public List<PlanInfo> merge(List<PlanInfo> sourceOnes, List<EmpWTimeInfo> sourceTwos) {
		return super.write(sourceOnes, sourceTwos, new PlanMergeVisitorEWT());
	}
}
