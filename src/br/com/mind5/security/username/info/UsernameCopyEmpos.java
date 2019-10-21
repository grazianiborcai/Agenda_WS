package br.com.mind5.security.username.info;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UsernameCopyEmpos extends InfoCopierTemplate<UsernameInfo, EmposInfo>{
	
	public UsernameCopyEmpos() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(EmposInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		
		return result;
	}
}
