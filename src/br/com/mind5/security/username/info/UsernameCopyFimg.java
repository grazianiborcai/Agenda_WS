package br.com.mind5.security.username.info;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.info.InfoCopierTemplate;

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
