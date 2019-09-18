package br.com.gda.business.address.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.customerPartner.info.CusparInfo;

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
