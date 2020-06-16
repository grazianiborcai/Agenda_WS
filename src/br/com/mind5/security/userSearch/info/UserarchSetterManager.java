package br.com.mind5.security.userSearch.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.authorizationGroup.info.Authgroup;

public final class UserarchSetterManager extends InfoSetterTemplate<UserarchInfo> {
	
	@Override protected UserarchInfo setAttrHook(UserarchInfo recordInfo) {
		recordInfo.codAuthGroup = Authgroup.STORE_MANAGER.getCodAuthGroup();		
		return recordInfo;
	}
}
