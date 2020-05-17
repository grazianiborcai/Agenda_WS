package br.com.mind5.security.username.info;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UsernameCopyMatext extends InfoCopierTemplate<UsernameInfo, MatextInfo> {
	
	public UsernameCopyMatext() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(MatextInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
