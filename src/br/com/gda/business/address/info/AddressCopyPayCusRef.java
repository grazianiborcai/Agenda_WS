package br.com.gda.business.address.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payService.payCustomer.info.PaycusInfo;

final class AddressCopyPayCusRef extends InfoCopierTemplate<AddressInfo, PaycusInfo>{
	
	public AddressCopyPayCusRef() {
		super();
	}
	
	
	
	@Override protected AddressInfo makeCopyHook(PaycusInfo source) {
		AddressInfo result = new AddressInfo();
		result.codOwner = source.codOwner;
		result.codAddress = source.codAddressRef;
		result.codUser = source.codUser;
		result.codLanguage = source.codLanguage;
		return result;
	}
}
