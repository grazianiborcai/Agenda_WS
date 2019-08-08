package br.com.gda.business.person.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.security.user.info.UserInfo;

final class PersonCopyUser extends InfoCopierTemplate<PersonInfo, UserInfo>{
	
	public PersonCopyUser() {
		super();
	} 
	
	
	
	@Override protected PersonInfo makeCopyHook(UserInfo source) {
		PersonInfo result = PersonInfo.copyFrom(source.personData);
		result.username = source.username;
		return result;
	}
}
