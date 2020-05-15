package br.com.mind5.security.userSearch.info;

import br.com.mind5.business.refundPolicy.info.RefupolInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UserarchCopyRefupol extends InfoCopierTemplate<UserarchInfo, RefupolInfo> {
	
	public UserarchCopyRefupol() {
		super();
	}
	
	
	
	@Override protected UserarchInfo makeCopyHook(RefupolInfo source) {
		UserarchInfo result = new UserarchInfo();
		
		result.codOwner = source.codOwner;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
