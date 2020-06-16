package br.com.mind5.security.otpUserPassword.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class OtperasSetterLChanged extends InfoSetterTemplate<OtperasInfo> {
	
	@Override protected OtperasInfo setAttrHook(OtperasInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
