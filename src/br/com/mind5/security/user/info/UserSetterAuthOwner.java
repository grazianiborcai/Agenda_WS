package br.com.mind5.security.user.info;

import br.com.mind5.business.masterData.info.common.AuthGroup;
import br.com.mind5.info.InfoSetterTemplate;

public final class UserSetterAuthOwner extends InfoSetterTemplate<UserInfo> {
	
	@Override protected UserInfo setAttrHook(UserInfo recordInfo) {
		recordInfo.codAuthGroup = AuthGroup.OWNER.getCodAuthGroup();
		return recordInfo;
	}
}
