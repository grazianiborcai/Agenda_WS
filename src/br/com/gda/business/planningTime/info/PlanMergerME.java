package br.com.gda.business.planningTime.info;

import java.util.List;

import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.info.InfoMerger_;

final class PlanMergerME extends InfoMerger_<PlanInfo, PlanInfo, EmpmatInfo> {
	public PlanInfo merge(PlanInfo sourceOne, EmpmatInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PlanMergeVisitorME());
	}
	
	
	
	public List<PlanInfo> merge(List<PlanInfo> sourceOnes, List<EmpmatInfo> sourceTwos) {
		return super.write(sourceOnes, sourceTwos, new PlanMergeVisitorME());
	}
}
