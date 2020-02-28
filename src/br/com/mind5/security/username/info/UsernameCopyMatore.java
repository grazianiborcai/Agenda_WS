package br.com.mind5.security.username.info;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UsernameCopyMatore extends InfoCopierTemplate<UsernameInfo, MatoreInfo>{
	
	public UsernameCopyMatore() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(MatoreInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
