package br.com.mind5.security.user.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class UserSetterCodUser extends InfoSetterTemplate<UserInfo> {
	
	@Override protected UserInfo setAttrHook(UserInfo recordInfo) {
		recordInfo.codUser = recordInfo.lastChangedBy;		
		return recordInfo;
	}
}
