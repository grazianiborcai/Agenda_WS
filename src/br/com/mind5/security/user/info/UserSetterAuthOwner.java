package br.com.mind5.security.user.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.common.AuthorizationGroup;

public final class UserSetterAuthOwner extends InfoSetterTemplate<UserInfo> {
	
	@Override protected UserInfo setAttrHook(UserInfo recordInfo) {
		recordInfo.codAuthGroup = AuthorizationGroup.OWNER.getCodAuthGroup();
		return recordInfo;
	}
}
