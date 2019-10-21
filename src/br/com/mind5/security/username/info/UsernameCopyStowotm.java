package br.com.mind5.security.username.info;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.info.InfoCopierTemplate;

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
