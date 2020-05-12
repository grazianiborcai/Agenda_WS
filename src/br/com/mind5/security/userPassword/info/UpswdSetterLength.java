package br.com.mind5.security.userPassword.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class UpswdSetterLength extends InfoSetterTemplate<UpswdInfo> {
	private final int LENGTH = 256;
	
	
	@Override protected UpswdInfo setAttrHook(UpswdInfo recordInfo) {
		recordInfo.hashLength = LENGTH;
		return recordInfo;
	}
}
