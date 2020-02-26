package br.com.mind5.payment.storePartner.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

final class StoparCopyOrdmoip extends InfoCopierTemplate<StoparInfo, OrdmoipInfo>{
	
	public StoparCopyOrdmoip() {
		super();
	}
	
	
	
	@Override protected StoparInfo makeCopyHook(OrdmoipInfo source) {
		StoparInfo result = new StoparInfo();
		
		result.codOwner = source.payordemData.codOwner;
		result.codStore = source.payordemData.codStore;	
		result.codPayPartner = source.codPayPartner;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
