package br.com.mind5.payment.customerPartner.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.payOrder.info.PayordInfo;

final class CusparCopyPayord extends InfoCopierTemplate<CusparInfo, PayordInfo>{
	
	public CusparCopyPayord() {
		super();
	}
	
	
	
	@Override protected CusparInfo makeCopyHook(PayordInfo source) {
		CusparInfo result = new CusparInfo();
		result.codOwner = source.codOwner;
		result.codPayCustomer = source.codPayCustomer;	
		result.codLanguage = source.codLanguage;	
		result.username = source.username;	
		
		return result;
	}
}
