package br.com.gda.business.address.info;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.info.InfoCopierTemplate;

final class AddressCopyOwner extends InfoCopierTemplate<AddressInfo, OwnerInfo>{
	
	public AddressCopyOwner() {
		super();
	}
	
	
	
	@Override protected AddressInfo makeCopyHook(OwnerInfo source) {
		AddressInfo result = new AddressInfo();
		result.codOwner = source.codOwner;
		result.codOwnerRef = source.codOwner;
		result.lastChangedBy = source.lastChangedBy;
		result.codLanguage = source.codLanguage;
		return result;
	}
}
