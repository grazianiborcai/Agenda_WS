package br.com.mind5.payment.storePartner.info;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class StoparCopyPlanata extends InfoCopierTemplate<StoparInfo, PlanataInfo> {
	
	public StoparCopyPlanata() {
		super();
	}
	
	
	
	@Override protected StoparInfo makeCopyHook(PlanataInfo source) {
		StoparInfo result = new StoparInfo();
		
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;		
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
