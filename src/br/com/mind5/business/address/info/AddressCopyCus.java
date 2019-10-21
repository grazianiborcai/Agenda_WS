package br.com.mind5.business.address.info;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class AddressCopyCus extends InfoCopierTemplate<AddressInfo, CusInfo>{
	
	public AddressCopyCus() {
		super();
	}
	
	
	
	@Override protected AddressInfo makeCopyHook(CusInfo source) {
		AddressInfo result = new AddressInfo();
		result.codOwner = source.codOwner;
		result.codCustomer = source.codCustomer;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		return result;
	}
}
