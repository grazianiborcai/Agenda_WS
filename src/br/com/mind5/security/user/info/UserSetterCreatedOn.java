package br.com.mind5.security.user.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class UserSetterCreatedOn extends InfoSetterTemplate<UserInfo> {
	
	@Override protected UserInfo setAttrHook(UserInfo recordInfo) {
		recordInfo.createdOn = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
