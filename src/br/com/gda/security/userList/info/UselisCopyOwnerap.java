package br.com.gda.security.userList.info;

import br.com.gda.business.ownerSnapshot.info.OwnerapInfo;
import br.com.gda.info.InfoCopierTemplate;

final class UselisCopyOwnerap extends InfoCopierTemplate<UselisInfo, OwnerapInfo>{
	
	public UselisCopyOwnerap() {
		super();
	}
	
	
	
	@Override protected UselisInfo makeCopyHook(OwnerapInfo source) {
		UselisInfo result = new UselisInfo();
		result.codOwner = source.codOwner;
		result.codUser = source.codUser;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		return result;
	}
}
