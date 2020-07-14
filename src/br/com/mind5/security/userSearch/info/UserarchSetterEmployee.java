package br.com.mind5.security.userSearch.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.common.AuthorizationGroup;

public final class UserarchSetterEmployee extends InfoSetterTemplate<UserarchInfo> {
	
	@Override protected UserarchInfo setAttrHook(UserarchInfo recordInfo) {
		recordInfo.codAuthGroup = AuthorizationGroup.EMPLOYEE.getCodAuthGroup();		
		return recordInfo;
	}
}
