package br.com.mind5.security.user.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class UserSetterLChangedBy extends InfoSetterTemplate<UserInfo> {
	
	@Override protected UserInfo setAttrHook(UserInfo recordInfo) {
		recordInfo.lastChangedBy = recordInfo.codUser;		
		return recordInfo;
	}
}
