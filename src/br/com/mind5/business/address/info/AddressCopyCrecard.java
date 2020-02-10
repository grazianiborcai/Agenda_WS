package br.com.mind5.business.address.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

final class AddressCopyCrecard extends InfoCopierTemplate<AddressInfo, CrecardInfo>{
	
	public AddressCopyCrecard() {
		super();
	}
	
	
	
	@Override protected AddressInfo makeCopyHook(CrecardInfo source) {
		AddressInfo result = new AddressInfo();
		
		result.codOwner = source.codOwner;
		result.codAddress = source.codAddressHolder;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
