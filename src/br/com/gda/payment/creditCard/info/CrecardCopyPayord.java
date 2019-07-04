package br.com.gda.payment.creditCard.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.payOrder.info.PayordInfo;

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
