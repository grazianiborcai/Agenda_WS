package br.com.mind5.security.otpProspectStore.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class OtporeSetterLChanged extends InfoSetterTemplate<OtporeInfo> {
	
	@Override protected OtporeInfo setAttrHook(OtporeInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
