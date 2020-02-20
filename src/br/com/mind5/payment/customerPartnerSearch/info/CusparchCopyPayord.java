package br.com.mind5.payment.customerPartnerSearch.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.payOrder.info.PayordInfo;

final class CusparchCopyPayord extends InfoCopierTemplate<CusparchInfo, PayordInfo>{
	
	public CusparchCopyPayord() {
		super();
	}
	
	
	
	@Override protected CusparchInfo makeCopyHook(PayordInfo source) {
		CusparchInfo result = new CusparchInfo();
		
		result.codOwner = source.codOwner;
		result.codUser = source.codUser;	
		result.codPayCustomer = source.codPayCustomer;	
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
