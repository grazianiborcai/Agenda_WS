package br.com.gda.business.address.info;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.info.InfoCopierTemplate;

final class AddressCopyOwnerKey extends InfoCopierTemplate<AddressInfo, OwnerInfo>{
	
	public AddressCopyOwnerKey() {
		super();
	}
	
	
	
	@Override protected AddressInfo makeCopyHook(OwnerInfo source) {
		AddressInfo result = new AddressInfo();
		result.codOwner = source.codOwner;
		result.codOwnerRef = source.codOwner;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		return result;
	}
}
