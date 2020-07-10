package br.com.mind5.payment.storePartnerSearch.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;

final class StoparchCopyRefumoip extends InfoCopierTemplate<StoparchInfo, RefumoipInfo> {
	
	public StoparchCopyRefumoip() {
		super();
	}
	
	
	
	@Override protected StoparchInfo makeCopyHook(RefumoipInfo source) {
		StoparchInfo result = new StoparchInfo();
		
		result.codOwner = source.codOwner;
		result.codPayPartner = source.codPayPartner;
		result.idPayPartnerStore = source.itemReceiver;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
