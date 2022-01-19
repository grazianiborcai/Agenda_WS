package br.com.mind5.security.username.info;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UsernameCopyPet extends InfoCopierTemplate<UsernameInfo, PetInfo> {
	
	public UsernameCopyPet() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(PetInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
