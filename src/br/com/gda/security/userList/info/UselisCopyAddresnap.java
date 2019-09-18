package br.com.gda.security.userList.info;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.info.InfoCopierTemplate;

final class UselisCopyAddresnap extends InfoCopierTemplate<UselisInfo, AddresnapInfo>{
	
	public UselisCopyAddresnap() {
		super();
	}
	
	
	
	@Override protected UselisInfo makeCopyHook(AddresnapInfo source) {
		UselisInfo result = new UselisInfo();
		result.codOwner = source.codOwner;
		result.codUser = source.codUser;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		return result;
	}
}
