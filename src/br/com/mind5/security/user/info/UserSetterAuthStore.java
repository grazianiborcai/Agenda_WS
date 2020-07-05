package br.com.mind5.security.user.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.common.AuthorizationGroup;

public final class UserSetterAuthStore extends InfoSetterTemplate<UserInfo> {
	
	@Override protected UserInfo setAttrHook(UserInfo recordInfo) {
		recordInfo.codAuthGroup = AuthorizationGroup.STORE_MANAGER.getCodAuthGroup();
		return recordInfo;
	}
}
