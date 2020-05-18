package br.com.mind5.security.username.info;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UsernameCopyRefupore extends InfoCopierTemplate<UsernameInfo, RefuporeInfo> {
	
	public UsernameCopyRefupore() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(RefuporeInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
