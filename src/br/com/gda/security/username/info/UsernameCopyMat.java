package br.com.gda.security.username.info;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoCopierTemplate;

final class UsernameCopyMat extends InfoCopierTemplate<UsernameInfo, MatInfo>{
	
	public UsernameCopyMat() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(MatInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		
		return result;
	}
}
