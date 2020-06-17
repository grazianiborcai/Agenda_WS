package br.com.mind5.security.userPassword.info;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.security.user.info.UserInfo;

final class UpswdCopyUser extends InfoCopierTemplate<UpswdInfo, UserInfo> {
	
	public UpswdCopyUser() {
		super();
	} 
	
	
	
	@Override protected UpswdInfo makeCopyHook(UserInfo source) {
		UpswdInfo result = new UpswdInfo();		
		
		result.codOwner = source.codOwner;
		result.codUser = source.codUser;	
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		result.persolisData = PersolisInfo.copyFrom(source.personData);
		
		return result;
	}
}
