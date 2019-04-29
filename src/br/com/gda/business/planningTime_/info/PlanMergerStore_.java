package br.com.gda.business.planningTime_.info;

import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.info.InfoMerger_;

final class PlanMergerStore_ extends InfoMerger_<PlanInfo, PlanInfo, StoreInfo> {
	public PlanInfo merge(PlanInfo sourceOne, StoreInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PlanVisiMergeStore_());
	}
	
	
	
	public List<PlanInfo> merge(List<PlanInfo> sourceOnes, List<StoreInfo> sourceTwos) {
		return super.write(sourceOnes, sourceTwos, new PlanVisiMergeStore_());
	}
}
