package br.com.mind5.security.username.info;

import br.com.mind5.business.orderListAuth.info.OrdistauInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UsernameCopyOrdistau extends InfoCopierTemplate<UsernameInfo, OrdistauInfo>{
	
	public UsernameCopyOrdistau() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(OrdistauInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		
		return result;
	}
}
