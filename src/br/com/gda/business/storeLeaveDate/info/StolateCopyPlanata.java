package br.com.gda.business.storeLeaveDate.info;

import br.com.gda.business.planingData.info.PlanataInfo;
import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.info.InfoUniquifyHelper;

final class StolevateCopyPlanata extends InfoCopierTemplate<StolevateInfo, PlanataInfo>{
	
	public StolevateCopyPlanata() {
		super(new InfoUniquifyHelper<StolevateInfo>());
	}
	
	
	
	@Override protected StolevateInfo makeCopyHook(PlanataInfo source) {
		StolevateInfo result = new StolevateInfo();
			
		result.codOwner = source.codOwner;	
		result.codStore = source.codStore;
		result.dateValidFrom = source.date;
		result.dateValidTo = source.date;
		return result;
	}
}
