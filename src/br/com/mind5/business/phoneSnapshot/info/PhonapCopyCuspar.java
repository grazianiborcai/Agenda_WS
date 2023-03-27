package br.com.mind5.business.phoneSnapshot.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class PhonapCopyCuspar extends InfoCopierTemplate<PhonapInfo, CusparInfo> {
	
	public PhonapCopyCuspar() {
		super();
	}
	
	
	
	@Override protected PhonapInfo makeCopyHook(CusparInfo source) {
		PhonapInfo result = new PhonapInfo();
		
		result.codOwner    = source.codOwner;
		result.codPhone    = source.codPhone;
		result.username    = source.username;
		result.codSnapshot = source.codPhoneSnapshot;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
