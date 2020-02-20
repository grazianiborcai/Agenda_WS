package br.com.mind5.payment.creditCardSearch.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.payOrder.info.PayordInfo;

final class CrecarchCopyPayord extends InfoCopierTemplate<CrecarchInfo, PayordInfo>{
	
	public CrecarchCopyPayord() {
		super();
	}
	
	
	
	@Override protected CrecarchInfo makeCopyHook(PayordInfo source) {
		CrecarchInfo result = new CrecarchInfo();
		
		result.codOwner = source.codOwner;
		result.codCreditCard = source.codCreditCard;	
		result.codUser = source.codUser;
		result.codLanguage = source.codLanguage;	
		result.username = source.username;	
		
		return result;
	}
}
