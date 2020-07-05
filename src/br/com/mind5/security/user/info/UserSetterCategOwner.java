package br.com.mind5.security.user.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.common.UserCategory;

public final class UserSetterCategOwner extends InfoSetterTemplate<UserInfo> {
	
	@Override protected UserInfo setAttrHook(UserInfo recordInfo) {
		recordInfo.codUserCategory = UserCategory.OWNER.getCodUserCateg();
		return recordInfo;
	}
}
