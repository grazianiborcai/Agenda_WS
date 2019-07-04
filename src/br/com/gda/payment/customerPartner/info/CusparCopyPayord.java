package br.com.gda.payment.customerPartner.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.payOrder.info.PayordInfo;

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
