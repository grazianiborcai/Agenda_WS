package br.com.mind5.file.fileImageList.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.security.user.info.UserInfo;

final class FimistCopyUser extends InfoCopierTemplate<FimistInfo, UserInfo>{
	
	public FimistCopyUser() {
		super();
	}
	
	
	
	@Override protected FimistInfo makeCopyHook(UserInfo source) {
		FimistInfo result = new FimistInfo();
		
		result.codOwner = source.codOwner;
		result.codUser = source.codUser;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
