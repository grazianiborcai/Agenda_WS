package br.com.gda.business.planningTime_.info;

import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class PlanMergerEmp_ extends InfoMerger_<PlanInfo, PlanInfo, EmpInfo> {
	public PlanInfo merge(PlanInfo sourceOne, EmpInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PlanVisiMergeEmp_());
	}
	
	
	
	public List<PlanInfo> merge(List<PlanInfo> sourceOnes, List<EmpInfo> sourceTwos) {
		return super.write(sourceOnes, sourceTwos, new PlanVisiMergeEmp_());
	}
}
