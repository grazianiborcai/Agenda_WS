package br.com.gda.business.address.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payService.payCustomer.info.PayCusInfo;

final class AddressCopyPayCusRef extends InfoCopierTemplate<AddressInfo, PayCusInfo>{
	
	public AddressCopyPayCusRef() {
		super();
	}
	
	
	
	@Override protected AddressInfo makeCopyHook(PayCusInfo source) {
		AddressInfo result = new AddressInfo();
		result.codOwner = source.codOwner;
		result.codAddress = source.codAddressRef;
		result.codUser = source.codUser;
		return result;
	}
}
