package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.payOrder.info.PayordInfo;

final class MultmoipCopyPayord extends InfoCopierTemplate<MultmoipInfo, PayordInfo>{
	
	public MultmoipCopyPayord() {
		super();
	}
	
	
	
	@Override protected MultmoipInfo makeCopyHook(PayordInfo source) {
		MultmoipInfo result = new MultmoipInfo();
		
		result.codOwner = source.codOwner;
		result.codPayOrder = source.codPayOrder;	
		result.idOrderPartner = source.idOrderPartner;
		result.statusOrderPartner = source.statusOrderPartner;
		result.amountTotalPartner = source.amountTotalPartner;
		result.amountCurrencyPartner = source.amountCurrencyPartner;		
		result.codLanguage = source.codLanguage;
		result.cardCvc = source.cardCvc;
		result.username = source.username;		
		
		return result;
	}
}
