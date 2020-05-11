package br.com.mind5.security.user.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class UserSetterUsernameDaemon extends InfoSetterTemplate<UserInfo> {
	
	@Override protected UserInfo setAttrHook(UserInfo recordInfo) {
		recordInfo.username = "DAEMON" + String.valueOf(recordInfo.codOwner);		
		return recordInfo;
	}
}
