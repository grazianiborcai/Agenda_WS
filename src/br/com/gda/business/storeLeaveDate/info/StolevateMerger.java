package br.com.gda.business.storeLeaveDate.info;

import java.util.List;

import br.com.gda.business.planningTime_.info.PlanDataInfo;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.security.username.info.UsernameInfo;

public final class StolevateMerger extends InfoWritterFactory_<StolevateInfo> {
	
	public StolevateMerger() {
		super(new StolevateUniquifier());
	}
	
	
	
	public StolevateInfo merge(PlanDataInfo sourceOne, StolevateInfo sourceTwo) {
		return new StolevateMergerPlan().merge(sourceOne, sourceTwo);		
	}
	
	
	
	public StolevateInfo merge(StolevateInfo sourceOne, StolevateInfo sourceTwo) {
		return new StolevateMergerToDelete().merge(sourceOne, sourceTwo);		
	}
	
	
	
	public StolevateInfo merge(UsernameInfo sourceOne, StolevateInfo sourceTwo) {
		return new StolevateMergerUsername().merge(sourceOne, sourceTwo);		
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<StolevateInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {		
		if (sourceOnes.get(0) instanceof PlanDataInfo 	&&
			sourceTwos.get(0) instanceof StolevateInfo		)
			return new StolevateMergerPlan().merge((List<PlanDataInfo>) sourceOnes, (List<StolevateInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof StolevateInfo 	&&
			sourceTwos.get(0) instanceof StolevateInfo		)
			return new StolevateMergerToDelete().merge((List<StolevateInfo>) sourceOnes, (List<StolevateInfo>) sourceTwos);		
		
		
		if (sourceOnes.get(0) instanceof UsernameInfo 	&&
			sourceTwos.get(0) instanceof StolevateInfo		)
			return new StolevateMergerUsername().merge((List<UsernameInfo>) sourceOnes, (List<StolevateInfo>) sourceTwos);
		
		
		return null;
	}		
}
