package br.com.mind5.security.username.info;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UsernameCopyEmplate extends InfoCopierTemplate<UsernameInfo, EmplateInfo>{
	
	public UsernameCopyEmplate() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(EmplateInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
