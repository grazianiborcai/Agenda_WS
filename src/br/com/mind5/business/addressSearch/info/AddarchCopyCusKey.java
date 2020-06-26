package br.com.mind5.business.addressSearch.info;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class AddarchCopyCusKey extends InfoCopierTemplate<AddarchInfo, CusInfo> {
	
	public AddarchCopyCusKey() {
		super();
	}
	
	
	
	@Override protected AddarchInfo makeCopyHook(CusInfo source) {
		AddarchInfo result = new AddarchInfo();
		
		result.codOwner = source.codOwner;
		result.codCustomer = source.codCustomer;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
