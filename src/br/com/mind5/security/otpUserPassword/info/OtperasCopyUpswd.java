package br.com.mind5.security.otpUserPassword.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.security.userPassword.info.UpswdInfo;

final class OtperasCopyUpswd extends InfoCopierTemplate<OtperasInfo, UpswdInfo> {
	
	public OtperasCopyUpswd() {
		super();
	} 
	
	
	
	@Override protected OtperasInfo makeCopyHook(UpswdInfo source) {
		OtperasInfo result = new OtperasInfo();		
		
		result.codOwner = source.codOwner;
		result.codUser = source.codUser;	
		result.password = source.otpPassword;
		result.codLanguage = source.codLanguage;
		result.username = source.username;		
		
		return result;
	}
}
