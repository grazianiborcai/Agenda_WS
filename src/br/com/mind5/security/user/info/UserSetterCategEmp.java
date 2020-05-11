package br.com.mind5.security.user.info;

import br.com.mind5.business.masterData.info.common.UserCateg;
import br.com.mind5.info.InfoSetterTemplate;

public final class UserSetterCategEmp extends InfoSetterTemplate<UserInfo> {
	
	@Override protected UserInfo setAttrHook(UserInfo recordInfo) {
		recordInfo.codUserCategory = UserCateg.EMPLOYEE.getCodUserCateg();
		return recordInfo;
	}
}
