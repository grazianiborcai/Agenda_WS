package br.com.mind5.business.storeLeaveDate.info;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.info.InfoUniquifyHelper;

final class StolateCopyPlanata extends InfoCopierTemplate<StolateInfo, PlanataInfo>{
	
	public StolateCopyPlanata() {
		super(new InfoUniquifyHelper<StolateInfo>());
	}
	
	
	
	@Override protected StolateInfo makeCopyHook(PlanataInfo source) {
		StolateInfo result = new StolateInfo();
			
		result.codOwner = source.codOwner;	
		result.codStore = source.codStore;
		result.dateValidFrom = source.date;
		result.dateValidTo = source.date;
		return result;
	}
}
