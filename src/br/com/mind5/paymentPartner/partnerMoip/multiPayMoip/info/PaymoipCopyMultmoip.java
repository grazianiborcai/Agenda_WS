package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;

final class PaymoipCopyMultmoip extends InfoCopierTemplate<PaymoipInfo, MultmoipInfo> {
	
	public PaymoipCopyMultmoip() {
		super();
	}
	
	
	
	@Override protected PaymoipInfo makeCopyHook(MultmoipInfo source) {
		PaymoipInfo result = new PaymoipInfo();
		
		result.codOwner = source.codOwner;
		result.idOrderPartner = source.idOrderPartner;
		result.codCreditCard = source.codCreditCard;
		result.cardCvc = source.cardCvc;
		result.codLanguage = source.codLanguage;
		result.username = source.username;		
		
		return result;
	}
}
