package br.com.mind5.security.username.info;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UsernameCopyStolate extends InfoCopierTemplate<UsernameInfo, StolateInfo> {
	
	public UsernameCopyStolate() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(StolateInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
