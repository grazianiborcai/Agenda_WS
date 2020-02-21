package br.com.mind5.payment.payOrderItemSearch.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;

final class PayormarchCopyMultmoip extends InfoCopierTemplate<PayormarchInfo, MultmoipInfo>{
	
	public PayormarchCopyMultmoip() {
		super();
	}
	
	
	
	@Override protected PayormarchInfo makeCopyHook(MultmoipInfo source) {
		PayormarchInfo oneResult = new PayormarchInfo();
		
		oneResult.codOwner = source.codOwner;
		oneResult.codPayOrder = source.codPayOrder;
		oneResult.username = source.username;	
		oneResult.codLanguage = source.codLanguage;	
		
		return oneResult;
	}
}
