package br.com.mind5.security.userList.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.security.userAuthentication.info.UauthInfo;

final class UselisCopyUauth extends InfoCopierTemplate<UselisInfo, UauthInfo> {
	
	public UselisCopyUauth() {
		super();
	}
	
	
	
	@Override protected UselisInfo makeCopyHook(UauthInfo source) {
		UselisInfo result = new UselisInfo();
		
		result.codOwner = source.codOwner;	
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
