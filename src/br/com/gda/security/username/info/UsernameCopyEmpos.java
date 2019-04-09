package br.com.gda.security.username.info;

import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.info.InfoCopierTemplate;

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
