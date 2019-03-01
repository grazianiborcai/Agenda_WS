package br.com.gda.security.username.info;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.info.InfoCopierTemplate;

final class UsernameCopyOwner extends InfoCopierTemplate<UsernameInfo, OwnerInfo>{
	
	public UsernameCopyOwner() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(OwnerInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		
		return result;
	}
}
