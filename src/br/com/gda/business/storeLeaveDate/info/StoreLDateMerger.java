package br.com.gda.business.storeLeaveDate.info;

import java.util.List;

import br.com.gda.business.planningTime.info.PlanDataInfo;
import br.com.gda.info.InfoWritterFactory;

public final class StoreLDateMerger extends InfoWritterFactory<StoreLDateInfo> {
	
	public StoreLDateInfo merge(PlanDataInfo sourceOne, StoreLDateInfo sourceTwo) {
		return new StoreLDateMergerPlan().merge(sourceOne, sourceTwo);		
	}
	
	
	
	public List<StoreLDateInfo> merge(List<?> sourceOnes, List<?> sourceTwos) {
		return super.merge(sourceOnes, sourceTwos);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<StoreLDateInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {		
		if (sourceOnes.get(0) instanceof PlanDataInfo 	&&
			sourceTwos.get(0) instanceof StoreLDateInfo		)
			return new StoreLDateMergerPlan().merge((List<PlanDataInfo>) sourceOnes, (List<StoreLDateInfo>) sourceTwos);
		
		
		return null;
	}
		
		
}
