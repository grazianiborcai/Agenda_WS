package br.com.mind5.business.addressSnapshot.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;

final class AddresnapCopyCremoip extends InfoCopierTemplate<AddresnapInfo, CremoipInfo>{
	
	public AddresnapCopyCremoip() {
		super();
	}
	
	
	
	@Override protected AddresnapInfo makeCopyHook(CremoipInfo source) {
		AddresnapInfo result = new AddresnapInfo();
		
		result.codOwner = source.codOwner;
		result.codSnapshot = source.codAddressSnapshot;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
