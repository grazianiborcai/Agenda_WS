package br.com.mind5.security.user.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class UserSetterCreatedBy extends InfoSetterTemplate<UserInfo> {
	
	@Override protected UserInfo setAttrHook(UserInfo recordInfo) {
		recordInfo.createdBy = recordInfo.lastChangedBy;		
		return recordInfo;
	}
}
