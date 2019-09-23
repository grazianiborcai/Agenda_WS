package br.com.gda.business.phoneSnapshot.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.security.userSnapshot.info.UserapInfo;

final class PhonapCopyUserapKey extends InfoCopierTemplate<PhonapInfo, UserapInfo>{
	
	public PhonapCopyUserapKey() {
		super();
	}
	
	
	
	@Override protected PhonapInfo makeCopyHook(UserapInfo source) {
		PhonapInfo result = new PhonapInfo();
		result.codOwner = source.codOwner;
		result.codUser = source.codUser;
		result.codUserSnapshot = source.codSnapshot;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		return result;
	}
}
