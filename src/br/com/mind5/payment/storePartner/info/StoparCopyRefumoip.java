package br.com.mind5.payment.storePartner.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;

final class StoparCopyRefumoip extends InfoCopierTemplate<StoparInfo, RefumoipInfo>{
	
	public StoparCopyRefumoip() {
		super();
	}
	
	
	
	@Override protected StoparInfo makeCopyHook(RefumoipInfo source) {
		StoparInfo result = new StoparInfo();
		
		result.codOwner = source.codOwner;
		result.idPayPartnerStore = source.itemReceiver;	
		result.codPayPartner = source.codPayPartner;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
