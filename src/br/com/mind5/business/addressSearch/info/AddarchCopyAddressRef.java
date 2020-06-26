package br.com.mind5.business.addressSearch.info;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class AddarchCopyAddressRef extends InfoCopierTemplate<AddarchInfo, AddressInfo> {
	
	public AddarchCopyAddressRef() {
		super();
	}
	
	
	
	@Override protected AddarchInfo makeCopyHook(AddressInfo source) {
		AddarchInfo result = new AddarchInfo();
		
		result.codOwner = source.codOwner;
		result.codCustomer = source.codCustomer;
		result.codStore = source.codStore;
		result.codEmployee = source.codEmployee;
		result.codUser = source.codUser;
		result.codOwnerRef = source.codOwnerRef;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
