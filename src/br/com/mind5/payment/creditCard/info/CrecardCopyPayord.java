package br.com.mind5.payment.creditCard.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.payOrder.info.PayordInfo;

final class CrecardCopyPayord extends InfoCopierTemplate<CrecardInfo, PayordInfo>{
	
	public CrecardCopyPayord() {
		super();
	}
	
	
	
	@Override protected CrecardInfo makeCopyHook(PayordInfo source) {
		CrecardInfo result = new CrecardInfo();
		result.codOwner = source.codOwner;
		result.codCreditCard = source.codCreditCard;	
		result.codPayCustomer = source.codPayCustomer;
		result.codLanguage = source.codLanguage;	
		result.username = source.username;	
		
		return result;
	}
}
