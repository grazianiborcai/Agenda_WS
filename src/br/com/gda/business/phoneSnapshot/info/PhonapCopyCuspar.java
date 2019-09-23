package br.com.gda.business.phoneSnapshot.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.customerPartner.info.CusparInfo;

final class PhonapCopyCuspar extends InfoCopierTemplate<PhonapInfo, CusparInfo>{
	
	public PhonapCopyCuspar() {
		super();
	}
	
	
	
	@Override protected PhonapInfo makeCopyHook(CusparInfo source) {
		PhonapInfo result = new PhonapInfo();
		result.codOwner = source.codOwner;
		result.codPhone = source.codPhone;
		result.codSnapshot = source.codPhoneSnapshot;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		return result;
	}
}
