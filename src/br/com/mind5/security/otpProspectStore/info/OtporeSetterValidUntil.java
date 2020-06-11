package br.com.mind5.security.otpProspectStore.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class OtporeSetterValidUntil extends InfoSetterTemplate<OtporeInfo> {
	
	@Override protected OtporeInfo setAttrHook(OtporeInfo recordInfo) {
		recordInfo.validUntil = DefaultValue.localDateTimeNow().plusHours(4);
		return recordInfo;
	}
}
