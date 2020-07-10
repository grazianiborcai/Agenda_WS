package br.com.mind5.payment.creditCardSearch.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;

final class CrecarchCopyPaymoip extends InfoCopierTemplate<CrecarchInfo, PaymoipInfo> {
	
	public CrecarchCopyPaymoip() {
		super();
	}
	
	
	
	@Override protected CrecarchInfo makeCopyHook(PaymoipInfo source) {
		CrecarchInfo result = new CrecarchInfo();
		
		result.codOwner = source.codOwner;
		result.codCreditCard = source.codCreditCard;	
		result.codPayPartner = source.codPayPartner;
		result.codLanguage = source.codLanguage;	
		result.username = source.username;	
		
		return result;
	}
}
