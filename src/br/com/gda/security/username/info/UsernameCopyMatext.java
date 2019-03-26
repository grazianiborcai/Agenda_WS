package br.com.gda.security.username.info;

import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.info.InfoCopierTemplate;

final class UsernameCopyMatext extends InfoCopierTemplate<UsernameInfo, MatextInfo>{
	
	public UsernameCopyMatext() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(MatextInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		
		return result;
	}
}
