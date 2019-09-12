package br.com.gda.security.username.info;

import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.info.InfoCopierTemplate;

final class UsernameCopyFimg extends InfoCopierTemplate<UsernameInfo, FimgInfo>{
	
	public UsernameCopyFimg() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(FimgInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		
		return result;
	}
}
