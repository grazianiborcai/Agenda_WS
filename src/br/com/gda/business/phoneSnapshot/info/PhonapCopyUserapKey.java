package br.com.gda.business.phoneSnapshot.info;

import br.com.gda.business.userSnapshot.info.UserapInfo;
import br.com.gda.info.InfoCopierTemplate;

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
		return result;
	}
}
