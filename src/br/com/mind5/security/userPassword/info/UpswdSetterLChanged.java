package br.com.mind5.security.userPassword.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class UpswdSetterLChanged extends InfoSetterTemplate<UpswdInfo> {
	
	@Override protected UpswdInfo setAttrHook(UpswdInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
