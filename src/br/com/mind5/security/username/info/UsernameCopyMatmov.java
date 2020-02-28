package br.com.mind5.security.username.info;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UsernameCopyMatmov extends InfoCopierTemplate<UsernameInfo, MatmovInfo>{
	
	public UsernameCopyMatmov() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(MatmovInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
