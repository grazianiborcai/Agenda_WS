package br.com.mind5.business.address.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;

final class AddressCopyCusmoip extends InfoCopierTemplate<AddressInfo, CusmoipInfo>{
	
	public AddressCopyCusmoip() {
		super();
	}
	
	
	
	@Override protected AddressInfo makeCopyHook(CusmoipInfo source) {
		AddressInfo result = new AddressInfo();
		
		result.codOwner = source.codOwner;
		result.codAddress = source.codAddress;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
