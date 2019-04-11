package br.com.gda.business.planningTime.info;

import java.util.List;

import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.info.InfoMerger;

final class PlanMergerEWT extends InfoMerger<PlanInfo, PlanInfo, EmpwotmInfo> {
	public PlanInfo merge(PlanInfo sourceOne, EmpwotmInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PlanMergeVisitorEWT());
	}
	
	
	
	public List<PlanInfo> merge(List<PlanInfo> sourceOnes, List<EmpwotmInfo> sourceTwos) {
		return super.write(sourceOnes, sourceTwos, new PlanMergeVisitorEWT());
	}
}
