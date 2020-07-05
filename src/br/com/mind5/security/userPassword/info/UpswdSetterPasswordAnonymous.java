package br.com.mind5.security.userPassword.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class UpswdSetterPasswordAnonymous extends InfoSetterTemplate<UpswdInfo> {	
	
    @Override protected UpswdInfo setAttrHook(UpswdInfo recordInfo) {
		recordInfo.password = "Anonymous#1";
		return recordInfo;
	}
}
