package br.com.mind5.message.emailUserOtp.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;

final class EmusotpCopyOtperas extends InfoCopierTemplate<EmusotpInfo, OtperasInfo> {
	
	public EmusotpCopyOtperas() {
		super();
	} 
	
	
	
	@Override protected EmusotpInfo makeCopyHook(OtperasInfo source) {
		EmusotpInfo result = new EmusotpInfo();
		
		result.codOwner = source.codOwner;
		result.password = source.password;
		result.codLanguage = source.codLanguage;		
		result.recipientAddr = source.uselisData.persolisData.email;
		
		return result;
	}
}
