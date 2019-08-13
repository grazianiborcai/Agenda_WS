package br.com.gda.security.userSnapshot.info;

import br.com.gda.business.storeSnapshot.info.StorapInfo;
import br.com.gda.info.InfoCopierTemplate;

final class UserapCopyStorap extends InfoCopierTemplate<UserapInfo, StorapInfo>{
	
	public UserapCopyStorap() {
		super();
	}
	
	
	
	@Override protected UserapInfo makeCopyHook(StorapInfo source) {
		UserapInfo result = new UserapInfo();
		result.codOwner = source.codOwner;
		result.codUser = source.codUser;
		result.codSnapshot = source.codUserSnapshot;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		return result;
	}
}
