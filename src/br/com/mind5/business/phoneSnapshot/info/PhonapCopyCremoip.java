package br.com.mind5.business.phoneSnapshot.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;

final class PhonapCopyCremoip extends InfoCopierTemplate<PhonapInfo, CremoipInfo>{
	
	public PhonapCopyCremoip() {
		super();
	}
	
	
	
	@Override protected PhonapInfo makeCopyHook(CremoipInfo source) {		
		PhonapInfo result = new PhonapInfo();
		
		result.codOwner = source.codOwner;
		result.codSnapshot = source.codPhoneSnapshot;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
