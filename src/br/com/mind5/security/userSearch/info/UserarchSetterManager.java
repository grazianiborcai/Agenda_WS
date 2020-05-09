package br.com.mind5.security.userSearch.info;

import br.com.mind5.business.masterData.info.common.AuthGroup;
import br.com.mind5.info.InfoSetterTemplate;

public final class UserarchSetterManager extends InfoSetterTemplate<UserarchInfo> {
	
	@Override protected UserarchInfo setAttrHook(UserarchInfo recordInfo) {
		recordInfo.codAuthGroup = AuthGroup.STORE_MANAGER.getCodAuthGroup();		
		return recordInfo;
	}
}
