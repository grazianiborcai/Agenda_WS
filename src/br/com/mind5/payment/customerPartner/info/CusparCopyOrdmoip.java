package br.com.mind5.payment.customerPartner.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

final class CusparCopyOrdmoip extends InfoCopierTemplate<CusparInfo, OrdmoipInfo>{
	
	public CusparCopyOrdmoip() {
		super();
	}
	
	
	
	@Override protected CusparInfo makeCopyHook(OrdmoipInfo source) {
		CusparInfo result = new CusparInfo();
		
		result.codOwner = source.codOwner;
		result.codPayCustomer = source.payordistData.codPayCustomer;	
		result.codLanguage = source.codLanguage;	
		result.username = source.username;	
		
		return result;
	}
}
