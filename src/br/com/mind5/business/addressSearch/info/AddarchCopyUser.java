package br.com.mind5.business.addressSearch.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.security.user.info.UserInfo;

final class AddarchCopyUser extends InfoCopierTemplate<AddarchInfo, UserInfo> {
	
	public AddarchCopyUser() {
		super();
	}
	
	
	
	@Override protected AddarchInfo makeCopyHook(UserInfo source) {
		AddarchInfo result = new AddarchInfo();
		
		result.codOwner = source.codOwner;
		result.codUser = source.codUser;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
