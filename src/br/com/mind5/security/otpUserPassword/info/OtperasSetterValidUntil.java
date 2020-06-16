package br.com.mind5.security.otpUserPassword.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class OtperasSetterValidUntil extends InfoSetterTemplate<OtperasInfo> {
	
	@Override protected OtperasInfo setAttrHook(OtperasInfo recordInfo) {
		recordInfo.validUntil = DefaultValue.localDateTimeNow().plusHours(4);
		return recordInfo;
	}
}
