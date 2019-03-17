package br.com.gda.security.username.info;

import br.com.gda.business.materialMovement.info.MatmovInfo;
import br.com.gda.info.InfoCopierTemplate;

final class UsernameCopyMatmov extends InfoCopierTemplate<UsernameInfo, MatmovInfo>{
	
	public UsernameCopyMatmov() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(MatmovInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		
		return result;
	}
}
