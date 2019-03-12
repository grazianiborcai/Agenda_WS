package br.com.gda.security.username.info;

import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.info.InfoCopierTemplate;

final class UsernameCopyStowotm extends InfoCopierTemplate<UsernameInfo, StowotmInfo>{
	
	public UsernameCopyStowotm() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(StowotmInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		
		return result;
	}
}
