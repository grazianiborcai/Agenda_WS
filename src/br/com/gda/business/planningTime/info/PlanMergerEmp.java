package br.com.gda.business.planningTime.info;

import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.info.InfoWriter;

final class PlanMergerEmp extends InfoWriter<PlanInfo, PlanInfo, EmpInfo> {
	public PlanInfo merge(PlanInfo sourceOne, EmpInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PlanMergeVisitorEmp());
	}
	
	
	
	public List<PlanInfo> merge(List<PlanInfo> sourceOnes, List<EmpInfo> sourceTwos) {
		return super.write(sourceOnes, sourceTwos, new PlanMergeVisitorEmp());
	}
}
