package br.com.gda.business.planningTime.info;

import java.util.List;

import br.com.gda.business.employeeLeaveDate.info.EmpLDateInfo;
import br.com.gda.business.storeLeaveDate.info.StoreLDateInfo;
import br.com.gda.info.InfoWriterFactory;

public final class PlanPruner extends InfoWriterFactory<PlanInfo> {

	public PlanInfo prune(PlanInfo sourceOne, StoreLDateInfo sourceTwo) {
		return new PlanPrunerSLD().prune(sourceOne, sourceTwo);
	}
	
	
	
	public PlanInfo prune(PlanInfo sourceOne, EmpLDateInfo sourceTwo) {
		return new PlanPrunerELD().prune(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<PlanInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {		
		if (sourceOnes.get(0) instanceof PlanInfo 	&&
			sourceTwos.get(0) instanceof StoreLDateInfo		)
			return new PlanPrunerSLD().prune((List<PlanInfo>) sourceOnes, (List<StoreLDateInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof PlanInfo 	&&
			sourceTwos.get(0) instanceof EmpLDateInfo		)
			return new PlanPrunerELD().prune((List<PlanInfo>) sourceOnes, (List<EmpLDateInfo>) sourceTwos);
		
		return null;
	}
}
