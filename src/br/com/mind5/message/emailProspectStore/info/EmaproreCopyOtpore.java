package br.com.mind5.message.emailProspectStore.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;

final class EmaproreCopyOtpore extends InfoCopierTemplate<EmaproreInfo, OtporeInfo>{
	
	public EmaproreCopyOtpore() {
		super();
	} 
	
	
	
	@Override protected EmaproreInfo makeCopyHook(OtporeInfo source) {
		EmaproreInfo result = new EmaproreInfo();
		
		result.codOwner = source.codOwner;
		result.password = source.password;
		result.codLanguage = source.codLanguage;		
		result.recipientAddr = source.prospectEmail;
		
		return result;
	}
}
