package br.com.mind5.security.userSearch.info;

import br.com.mind5.business.masterData.info.common.AuthGroup;
import br.com.mind5.info.InfoSetterTemplate;

public final class UserarchSetterOwner extends InfoSetterTemplate<UserarchInfo> {
	
	@Override protected UserarchInfo setAttrHook(UserarchInfo recordInfo) {
		recordInfo.codAuthGroup = AuthGroup.OWNER.getCodAuthGroup();		
		return recordInfo;
	}
}
