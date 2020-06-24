package br.com.mind5.security.userSearch.info;

import br.com.mind5.business.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UserarchCopySchedauth extends InfoCopierTemplate<UserarchInfo, SchedauthInfo> {
	
	public UserarchCopySchedauth() {
		super();
	}
	
	
	
	@Override protected UserarchInfo makeCopyHook(SchedauthInfo source) {
		UserarchInfo result = new UserarchInfo();
		
		result.codOwner = source.codOwner;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
