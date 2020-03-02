package br.com.mind5.payment.payOrderSearch.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;

final class PayordarchCopyRefumoip extends InfoCopierTemplate<PayordarchInfo, RefumoipInfo>{
	
	public PayordarchCopyRefumoip() {
		super();
	}
	
	
	
	@Override protected PayordarchInfo makeCopyHook(RefumoipInfo source) {
		PayordarchInfo oneResult = new PayordarchInfo();
		
		oneResult.codOwner = source.codOwner;
		oneResult.codPayOrder = source.codPayOrder;
		oneResult.codPayPartner = source.codPayPartner;
		oneResult.username = source.username;	
		oneResult.codLanguage = source.codLanguage;	
		
		return oneResult;
	}
}
