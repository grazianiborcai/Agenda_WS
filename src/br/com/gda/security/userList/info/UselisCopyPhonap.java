package br.com.gda.security.userList.info;

import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.info.InfoCopierTemplate;

final class UselisCopyPhonap extends InfoCopierTemplate<UselisInfo, PhonapInfo>{
	
	public UselisCopyPhonap() {
		super();
	}
	
	
	
	@Override protected UselisInfo makeCopyHook(PhonapInfo source) {
		UselisInfo result = new UselisInfo();
		result.codOwner = source.codOwner;
		result.codUser = source.codUser;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		return result;
	}
}
