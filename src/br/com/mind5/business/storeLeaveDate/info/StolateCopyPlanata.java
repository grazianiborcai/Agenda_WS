package br.com.mind5.business.storeLeaveDate.info;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class StolateCopyPlanata extends InfoCopierTemplate<StolateInfo, PlanataInfo> {
	
	public StolateCopyPlanata() {
		super(new StolateUniquifier());
	}
	
	
	
	@Override protected StolateInfo makeCopyHook(PlanataInfo source) {
		StolateInfo result = new StolateInfo();
			
		result.codOwner = source.codOwner;	
		result.codStore = source.codStore;
		result.dateValidFrom = source.date;
		result.dateValidTo = source.date;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
