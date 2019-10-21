package br.com.mind5.payment.storePartner.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

final class StoparCopyPayordem extends InfoCopierTemplate<StoparInfo, PayordemInfo>{
	
	public StoparCopyPayordem() {
		super();
	}
	
	
	
	@Override protected StoparInfo makeCopyHook(PayordemInfo source) {
		StoparInfo result = new StoparInfo();
		
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;	
		result.codPayPartner = source.codPayPartner;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
