package br.com.gda.business.planningTime_.info;

import java.util.List;

import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class PlanMergerME_ extends InfoMerger_<PlanInfo, PlanInfo, EmpmatInfo> {
	public PlanInfo merge(PlanInfo sourceOne, EmpmatInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PlanVisiMergeEmpmat_());
	}
	
	
	
	public List<PlanInfo> merge(List<PlanInfo> sourceOnes, List<EmpmatInfo> sourceTwos) {
		return super.write(sourceOnes, sourceTwos, new PlanVisiMergeEmpmat_());
	}
}
