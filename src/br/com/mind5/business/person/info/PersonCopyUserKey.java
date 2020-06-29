package br.com.mind5.business.person.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.security.user.info.UserInfo;

final class PersonCopyUserKey extends InfoCopierTemplate<PersonInfo, UserInfo> {
	
	public PersonCopyUserKey() {
		super();
	} 
	
	
	
	@Override protected PersonInfo makeCopyHook(UserInfo source) {
		PersonInfo result = new PersonInfo();
		
		result.codOwner = source.codOwner;
		result.codPerson = source.codPerson;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
