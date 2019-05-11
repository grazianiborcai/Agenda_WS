package br.com.gda.business.planningTime_.info;

import java.util.List;

import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class PlanMergerEWT_ extends InfoMerger_<PlanInfo, PlanInfo, EmpwotmInfo> {
	public PlanInfo merge(PlanInfo sourceOne, EmpwotmInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PlanVisiMergeEmpwotm_());
	}
	
	
	
	public List<PlanInfo> merge(List<PlanInfo> sourceOnes, List<EmpwotmInfo> sourceTwos) {
		return super.write(sourceOnes, sourceTwos, new PlanVisiMergeEmpwotm_());
	}
}
