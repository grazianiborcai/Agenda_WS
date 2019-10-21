package br.com.mind5.business.addressSnapshot.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

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
