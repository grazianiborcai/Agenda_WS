package br.com.gda.business.person.info;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoCopierTemplate;

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
