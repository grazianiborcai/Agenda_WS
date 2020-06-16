package br.com.mind5.security.userSearch.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.authorizationGroup.info.Authgroup;

public final class UserarchSetterOwner extends InfoSetterTemplate<UserarchInfo> {
	
	@Override protected UserarchInfo setAttrHook(UserarchInfo recordInfo) {
		recordInfo.codAuthGroup = Authgroup.OWNER.getCodAuthGroup();		
		return recordInfo;
	}
}
