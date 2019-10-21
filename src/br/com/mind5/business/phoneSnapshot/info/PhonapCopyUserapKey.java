package br.com.mind5.business.phoneSnapshot.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

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
