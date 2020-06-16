package br.com.mind5.security.user.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.authorizationGroup.info.Authgroup;

public final class UserSetterAuthOwner extends InfoSetterTemplate<UserInfo> {
	
	@Override protected UserInfo setAttrHook(UserInfo recordInfo) {
		recordInfo.codAuthGroup = Authgroup.OWNER.getCodAuthGroup();
		return recordInfo;
	}
}
