package br.com.mind5.security.user.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.common.UserCategory;

public final class UserSetterCategStore extends InfoSetterTemplate<UserInfo> {
	
	@Override protected UserInfo setAttrHook(UserInfo recordInfo) {
		recordInfo.codUserCategory = UserCategory.STORE.getCodUserCateg();
		return recordInfo;
	}
}
