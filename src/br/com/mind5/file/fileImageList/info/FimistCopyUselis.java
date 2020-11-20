package br.com.mind5.file.fileImageList.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.security.userList.info.UselisInfo;

final class FimistCopyUselis extends InfoCopierTemplate<FimistInfo, UselisInfo> {
	
	public FimistCopyUselis() {
		super();
	}
	
	
	
	@Override protected FimistInfo makeCopyHook(UselisInfo source) {
		FimistInfo result = new FimistInfo();
		
		result.codOwner = source.codOwner;
		result.codUser = source.codUser;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
