package br.com.mind5.security.userList.info;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.info.InfoCopierTemplate;

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
