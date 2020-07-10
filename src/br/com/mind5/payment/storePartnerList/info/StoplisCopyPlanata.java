package br.com.mind5.payment.storePartnerList.info;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class StoplisCopyPlanata extends InfoCopierTemplate<StoplisInfo, PlanataInfo> {
	
	public StoplisCopyPlanata() {
		super();
	}
	
	
	
	@Override protected StoplisInfo makeCopyHook(PlanataInfo source) {
		StoplisInfo result = new StoplisInfo();
		
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;		
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
