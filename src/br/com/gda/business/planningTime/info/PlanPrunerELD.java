package br.com.gda.business.planningTime.info;

import java.util.List;

import br.com.gda.business.employeeLeaveDate.info.EmpLDateInfo;
import br.com.gda.info.InfoWriter;

final class PlanPrunerELD extends InfoWriter<PlanInfo, PlanInfo, EmpLDateInfo> {
	public PlanInfo prune(PlanInfo sourceOne, EmpLDateInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PlanPruneVisitorELD());
	}
	
	
	
	public List<PlanInfo> prune(List<PlanInfo> sourceOnes, List<EmpLDateInfo> sourceTwos) {
		return super.write(sourceOnes, sourceTwos, new PlanPruneVisitorELD());
	}
}
