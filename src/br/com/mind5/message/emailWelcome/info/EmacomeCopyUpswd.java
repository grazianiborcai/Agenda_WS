package br.com.mind5.message.emailWelcome.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.security.userPassword.info.UpswdInfo;

final class EmacomeCopyUpswd extends InfoCopierTemplate<EmacomeInfo, UpswdInfo>{
	
	public EmacomeCopyUpswd() {
		super();
	} 
	
	
	
	@Override protected EmacomeInfo makeCopyHook(UpswdInfo source) {
		EmacomeInfo result = new EmacomeInfo();
		
		result.codOwner = source.codOwner;
		result.password = source.password;
		result.username = source.username;
		result.codLanguage = source.codLanguage;		
		result.personData = source.personData;
		
		return result;
	}
}
