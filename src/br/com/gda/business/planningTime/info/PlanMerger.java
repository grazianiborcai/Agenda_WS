package br.com.gda.business.planningTime.info;

import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.info.RecordMergerFacTempl;

public final class PlanMerger extends RecordMergerFacTempl<PlanInfo> {
	public PlanInfo merge(PlanInfo sourceOne, StoreWTimeInfo sourceTwo) {
		return new PlanMergerSWT().merge(sourceOne, sourceTwo);
	}
	
	
	public PlanInfo merge(PlanInfo sourceOne, StoreInfo sourceTwo) {
		return new PlanMergerStore().merge(sourceOne, sourceTwo);
	}
	
		
	
	@SuppressWarnings("unchecked")
	@Override protected List<PlanInfo> mergeHook(List<?> sourceOnes, List<?> sourceTwos) {		
		if (sourceOnes.get(0) instanceof PlanInfo 	&&
			sourceTwos.get(0) instanceof StoreWTimeInfo		)
			return new PlanMergerSWT().merge((List<PlanInfo>) sourceOnes, (List<StoreWTimeInfo>) sourceTwos);
		
		if (sourceOnes.get(0) instanceof PlanInfo 	&&
			sourceTwos.get(0) instanceof StoreInfo		)
			return new PlanMergerStore().merge((List<PlanInfo>) sourceOnes, (List<StoreInfo>) sourceTwos);
		
		return null;
	} 
}
