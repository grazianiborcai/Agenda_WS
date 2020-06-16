package br.com.mind5.security.user.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.authorizationGroup.info.Authgroup;

public final class UserSetterAuthEmp extends InfoSetterTemplate<UserInfo> {
	
	@Override protected UserInfo setAttrHook(UserInfo recordInfo) {
		recordInfo.codAuthGroup = Authgroup.EMPLOYEE.getCodAuthGroup();
		return recordInfo;
	}
}
