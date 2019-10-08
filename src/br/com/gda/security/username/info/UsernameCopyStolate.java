package br.com.gda.security.username.info;

import br.com.gda.business.storeLeaveDate.info.StolateInfo;
import br.com.gda.info.InfoCopierTemplate;

final class UsernameCopyStolate extends InfoCopierTemplate<UsernameInfo, StolateInfo>{
	
	public UsernameCopyStolate() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(StolateInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		
		return result;
	}
}
