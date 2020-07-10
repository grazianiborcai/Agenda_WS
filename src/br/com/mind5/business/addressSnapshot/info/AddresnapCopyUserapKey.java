package br.com.mind5.business.addressSnapshot.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

final class AddresnapCopyUserapKey extends InfoCopierTemplate<AddresnapInfo, UserapInfo> {
	
	public AddresnapCopyUserapKey() {
		super();
	}
	
	
	
	@Override protected AddresnapInfo makeCopyHook(UserapInfo source) {
		AddresnapInfo result = new AddresnapInfo();
		
		result.codOwner = source.codOwner;
		result.codUser = source.codUser;
		result.codUserSnapshot = source.codSnapshot;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
