package br.com.mind5.security.otp.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class OtpSetterLength extends InfoSetterTemplate<OtpInfo> {
	private final int LENGTH = 256;
	
	
	@Override protected OtpInfo setAttrHook(OtpInfo recordInfo) {
		recordInfo.hashLength = LENGTH;
		return recordInfo;
	}
}
