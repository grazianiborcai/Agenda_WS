package br.com.gda.business.planningTime_.info;

import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class PlanMergerMat_ extends InfoMerger_<PlanInfo, PlanInfo, MatInfo> {
	public PlanInfo merge(PlanInfo sourceOne, MatInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PlanVisiMergeMat_());
	}
	
	
	
	public List<PlanInfo> merge(List<PlanInfo> sourceOnes, List<MatInfo> sourceTwos) {
		return super.write(sourceOnes, sourceTwos, new PlanVisiMergeMat_());
	}
}
