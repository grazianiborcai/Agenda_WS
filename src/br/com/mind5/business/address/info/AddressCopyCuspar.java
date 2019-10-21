package br.com.mind5.business.address.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class AddressCopyCuspar extends InfoCopierTemplate<AddressInfo, CusparInfo>{
	
	public AddressCopyCuspar() {
		super();
	}
	
	
	
	@Override protected AddressInfo makeCopyHook(CusparInfo source) {
		AddressInfo result = new AddressInfo();
		result.codOwner = source.codOwner;
		result.codAddress = source.codAddress;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		return result;
	}
}
