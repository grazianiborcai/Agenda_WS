package br.com.mind5.security.username.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;

final class UsernameCopyRefem extends InfoCopierTemplate<UsernameInfo, RefemInfo>{
	
	public UsernameCopyRefem() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(RefemInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
