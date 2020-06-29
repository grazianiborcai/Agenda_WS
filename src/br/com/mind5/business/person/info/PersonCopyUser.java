package br.com.mind5.business.person.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.security.user.info.UserInfo;

final class PersonCopyUser extends InfoCopierTemplate<PersonInfo, UserInfo> {
	
	public PersonCopyUser() {
		super();
	} 
	
	
	
	@Override protected PersonInfo makeCopyHook(UserInfo source) {
		PersonInfo result = PersonInfo.copyFrom(source.personData);
		result.username = source.username;
		return result;
	}
}
