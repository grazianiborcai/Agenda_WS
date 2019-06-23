package br.com.gda.business.addressSnapshot.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.customerPartner.info.CusparInfo;

final class AddresnapCopyCuspar extends InfoCopierTemplate<AddresnapInfo, CusparInfo>{
	
	public AddresnapCopyCuspar() {
		super();
	}
	
	
	
	@Override protected AddresnapInfo makeCopyHook(CusparInfo source) {
		AddresnapInfo result = new AddresnapInfo();
		result.codOwner = source.codOwner;
		result.codAddress = source.codAddress;
		result.codUserSnapshot = source.codAddressSnapshot;
		result.codLanguage = source.codLanguage;
		return result;
	}
}
