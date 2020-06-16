package br.com.mind5.security.user.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.userCategory.info.Usereg;

public final class UserSetterCategEmp extends InfoSetterTemplate<UserInfo> {
	
	@Override protected UserInfo setAttrHook(UserInfo recordInfo) {
		recordInfo.codUserCategory = Usereg.EMPLOYEE.getCodUserCateg();
		return recordInfo;
	}
}
