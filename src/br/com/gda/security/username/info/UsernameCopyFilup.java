package br.com.gda.security.username.info;

import br.com.gda.file.fileUpload.info.FilupInfo;
import br.com.gda.info.InfoCopierTemplate;

final class UsernameCopyFilup extends InfoCopierTemplate<UsernameInfo, FilupInfo>{
	
	public UsernameCopyFilup() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(FilupInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		
		return result;
	}
}
