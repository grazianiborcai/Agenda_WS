package br.com.mind5.business.addressSnapshot.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;

final class AddresnapCopyCusmoip extends InfoCopierTemplate<AddresnapInfo, CusmoipInfo>{
	
	public AddresnapCopyCusmoip() {
		super();
	}
	
	
	
	@Override protected AddresnapInfo makeCopyHook(CusmoipInfo source) {
		AddresnapInfo result = new AddresnapInfo();
		
		result.codOwner = source.codOwner;
		result.codSnapshot = source.codAddressSnapshot;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
