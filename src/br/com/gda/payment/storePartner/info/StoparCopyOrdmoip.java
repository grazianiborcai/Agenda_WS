package br.com.gda.payment.storePartner.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;

final class StoparCopyOrdmoip extends InfoCopierTemplate<StoparInfo, OrdmoipInfo>{
	
	public StoparCopyOrdmoip() {
		super();
	}
	
	
	
	@Override protected StoparInfo makeCopyHook(OrdmoipInfo source) {
		StoparInfo result = new StoparInfo();
		
		result.codOwner = source.payordemData.codOwner;
		result.codStore = source.payordemData.codStore;	
		result.codPayPartner = source.payordemData.codPayPartner;
		result.codLanguage = source.payordemData.codLanguage;
		result.username = source.payordemData.username;
		
		return result;
	}
}
