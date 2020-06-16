package br.com.mind5.message.emailProspectStore.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;

final class EmaproreCopyOtperas extends InfoCopierTemplate<EmaproreInfo, OtperasInfo> {
	
	public EmaproreCopyOtperas() {
		super();
	} 
	
	
	
	@Override protected EmaproreInfo makeCopyHook(OtperasInfo source) {
		EmaproreInfo result = new EmaproreInfo();
		
		result.codOwner = source.codOwner;
		result.password = source.password;
		result.codLanguage = source.codLanguage;		
		result.recipientAddr = source.uselisData.persolisData.email;
		
		return result;
	}
}
