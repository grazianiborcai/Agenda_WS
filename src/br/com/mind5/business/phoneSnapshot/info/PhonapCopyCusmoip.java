package br.com.mind5.business.phoneSnapshot.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;

final class PhonapCopyCusmoip extends InfoCopierTemplate<PhonapInfo, CusmoipInfo> {
	
	public PhonapCopyCusmoip() {
		super();
	}
	
	
	
	@Override protected PhonapInfo makeCopyHook(CusmoipInfo source) {		
		PhonapInfo result = new PhonapInfo();
		
		result.codOwner = source.codOwner;
		result.codSnapshot = source.codPhoneSnapshot;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
