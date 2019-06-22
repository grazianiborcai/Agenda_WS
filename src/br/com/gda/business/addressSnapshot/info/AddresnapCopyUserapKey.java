package br.com.gda.business.addressSnapshot.info;

import br.com.gda.business.userSnapshot.info.UserapInfo;
import br.com.gda.info.InfoCopierTemplate;

final class AddresnapCopyUserapKey extends InfoCopierTemplate<AddresnapInfo, UserapInfo>{
	
	public AddresnapCopyUserapKey() {
		super();
	}
	
	
	
	@Override protected AddresnapInfo makeCopyHook(UserapInfo source) {
		AddresnapInfo result = new AddresnapInfo();
		result.codOwner = source.codOwner;
		result.codUser = source.codUser;
		result.codUserSnapshot = source.codSnapshot;
		result.codLanguage = source.codLanguage;
		return result;
	}
}
