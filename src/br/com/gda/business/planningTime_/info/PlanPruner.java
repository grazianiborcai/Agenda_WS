package br.com.gda.business.planningTime_.info;

import java.util.List;

import br.com.gda.business.age.info.AgeInfo;
import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.business.reserve.info.ReserveInfo;
import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.info.obsolete.InfoWritterFactory_;

public final class PlanPruner extends InfoWritterFactory_<PlanInfo> {

	public PlanInfo prune(PlanInfo sourceOne, StolevateInfo sourceTwo) {
		return new PlanPrunerSLD().prune(sourceOne, sourceTwo);
	}
	
	
	
	public PlanInfo prune(PlanInfo sourceOne, EmplevateInfo sourceTwo) {
		return new PlanPrunerELD().prune(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<PlanInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {		
		if (sourceOnes.get(0) instanceof PlanInfo 	&&
			sourceTwos.get(0) instanceof StolevateInfo		)
			return new PlanPrunerSLD().prune((List<PlanInfo>) sourceOnes, (List<StolevateInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof PlanInfo 	&&
			sourceTwos.get(0) instanceof EmplevateInfo		)
			return new PlanPrunerELD().prune((List<PlanInfo>) sourceOnes, (List<EmplevateInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof PlanInfo 	&&
			sourceTwos.get(0) instanceof ReserveInfo		)
			return new PlanPrunerReserve().prune((List<PlanInfo>) sourceOnes, (List<ReserveInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof PlanInfo 	&&
			sourceTwos.get(0) instanceof AgeInfo		)
			return new PlanPrunerAge().prune((List<PlanInfo>) sourceOnes, (List<AgeInfo>) sourceTwos);
		
		return null;
	}
}
