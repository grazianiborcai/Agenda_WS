package br.com.mind5.payment.customerPartner.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;

final class CusparCopyPaytus extends InfoCopierTemplate<CusparInfo, PaytusInfo>{
	
	public CusparCopyPaytus() {
		super();
	}
	
	
	
	@Override protected CusparInfo makeCopyHook(PaytusInfo source) {
		CusparInfo result = new CusparInfo();
		result.codOwner = source.codOwner;
		result.codPayCustomer = source.codPayCustomer;	
		result.codLanguage = source.codLanguage;	
		result.username = source.username;	
		
		return result;
	}
}
