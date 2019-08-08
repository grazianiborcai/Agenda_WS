package br.com.gda.business.addressSnapshot.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.security.userSnapshot.info.UserapInfo;

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
