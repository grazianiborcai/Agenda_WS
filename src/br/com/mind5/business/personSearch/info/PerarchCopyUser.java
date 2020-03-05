package br.com.mind5.business.personSearch.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.security.user.info.UserInfo;

final class PerarchCopyUser extends InfoCopierTemplate<PerarchInfo, UserInfo>{
	
	public PerarchCopyUser() {
		super();
	}
	
	
	
	@Override protected PerarchInfo makeCopyHook(UserInfo source) {
		PerarchInfo result = new PerarchInfo();
		
		result.codOwner = source.codOwner;
		result.codPerson = source.codPerson;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
