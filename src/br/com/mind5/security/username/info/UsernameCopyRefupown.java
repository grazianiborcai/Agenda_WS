package br.com.mind5.security.username.info;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UsernameCopyRefupown extends InfoCopierTemplate<UsernameInfo, RefupownInfo> {
	
	public UsernameCopyRefupown() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(RefupownInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
