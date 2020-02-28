package br.com.mind5.security.username.info;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UsernameCopyMat extends InfoCopierTemplate<UsernameInfo, MatInfo>{
	
	public UsernameCopyMat() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(MatInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
