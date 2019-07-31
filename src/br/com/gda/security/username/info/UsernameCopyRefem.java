package br.com.gda.security.username.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.refundOrderItem.info.RefemInfo;

final class UsernameCopyRefem extends InfoCopierTemplate<UsernameInfo, RefemInfo>{
	
	public UsernameCopyRefem() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(RefemInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		
		return result;
	}
}
