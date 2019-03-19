package br.com.gda.security.username.info;

import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.info.InfoCopierTemplate;

final class UsernameCopyMatore extends InfoCopierTemplate<UsernameInfo, MatoreInfo>{
	
	public UsernameCopyMatore() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(MatoreInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		
		return result;
	}
}
