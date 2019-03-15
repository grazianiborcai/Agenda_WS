package br.com.gda.security.username.info;

import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.info.InfoCopierTemplate;

final class UsernameCopyStolevate extends InfoCopierTemplate<UsernameInfo, StolevateInfo>{
	
	public UsernameCopyStolevate() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(StolevateInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		
		return result;
	}
}
