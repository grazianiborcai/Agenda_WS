package br.com.gda.security.userPassword.info;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.security.user.info.UserInfo;

final class UpswdCopyUser extends InfoCopierTemplate<UpswdInfo, UserInfo>{
	
	public UpswdCopyUser() {
		super();
	} 
	
	
	
	@Override protected UpswdInfo makeCopyHook(UserInfo source) {
		UpswdInfo result = new UpswdInfo();		
		result.codOwner = source.codOwner;
		result.codUser = source.codUser;	
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		result.personData = PersonInfo.copyFrom(source.personData);
		
		return result;
	}
}
