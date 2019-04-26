package br.com.gda.business.address.info;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.info.InfoCopierTemplate;

final class AddressCopyCus extends InfoCopierTemplate<AddressInfo, CusInfo>{
	
	public AddressCopyCus() {
		super();
	}
	
	
	
	@Override protected AddressInfo makeCopyHook(CusInfo source) {
		AddressInfo result = new AddressInfo();
		result.codOwner = source.codOwner;
		result.codCustomer = source.codCustomer;
		return result;
	}
}
