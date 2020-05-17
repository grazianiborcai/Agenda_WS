package br.com.mind5.security.username.info;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UsernameCopyOrdist extends InfoCopierTemplate<UsernameInfo, OrdistInfo> {
	
	public UsernameCopyOrdist() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(OrdistInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
