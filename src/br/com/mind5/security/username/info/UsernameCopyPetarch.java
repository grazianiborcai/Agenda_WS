package br.com.mind5.security.username.info;

import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UsernameCopyPetarch extends InfoCopierTemplate<UsernameInfo, PetarchInfo> {
	
	public UsernameCopyPetarch() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(PetarchInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
