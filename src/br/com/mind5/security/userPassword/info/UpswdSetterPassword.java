package br.com.mind5.security.userPassword.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class UpswdSetterPassword extends InfoSetterTemplate<UpswdInfo> {
	
	@Override protected UpswdInfo setAttrHook(UpswdInfo recordInfo) {
		recordInfo.password = recordInfo.passwordToChange;
		return recordInfo;
	}
}
