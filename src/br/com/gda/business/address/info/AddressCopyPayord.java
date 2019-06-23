package br.com.gda.business.address.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.payOrder.info.PayordInfo;

final class AddressCopyPayord extends InfoCopierTemplate<AddressInfo, PayordInfo>{
	
	public AddressCopyPayord() {
		super();
	}
	
	
	
	@Override protected AddressInfo makeCopyHook(PayordInfo source) {
		AddressInfo result = new AddressInfo();
		result.codOwner = source.codOwner;
		result.codAddress = source.codAddressPay;
		result.codLanguage = source.codLanguage;
		return result;
	}
}
