package br.com.mind5.business.addressSearch.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class AddarchCopyCuspar extends InfoCopierTemplate<AddarchInfo, CusparInfo> {
	
	public AddarchCopyCuspar() {
		super();
	}
	
	
	
	@Override protected AddarchInfo makeCopyHook(CusparInfo source) {
		AddarchInfo result = new AddarchInfo();
		
		result.codOwner = source.codOwner;
		result.codAddress = source.codAddress;
		result.codUser = source.codUser;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
