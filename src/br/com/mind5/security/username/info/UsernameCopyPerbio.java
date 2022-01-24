package br.com.mind5.security.username.info;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UsernameCopyPerbio extends InfoCopierTemplate<UsernameInfo, PerbioInfo> {
	
	public UsernameCopyPerbio() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(PerbioInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
