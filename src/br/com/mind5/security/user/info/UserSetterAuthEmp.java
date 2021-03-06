package br.com.mind5.security.user.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.common.AuthorizationGroup;

public final class UserSetterAuthEmp extends InfoSetterTemplate<UserInfo> {
	
	@Override protected UserInfo setAttrHook(UserInfo recordInfo) {
		recordInfo.codAuthGroup = AuthorizationGroup.EMPLOYEE.getCodAuthGroup();
		return recordInfo;
	}
}
