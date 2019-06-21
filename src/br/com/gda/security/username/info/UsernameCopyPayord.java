package br.com.gda.security.username.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.payOrder.info.PayordInfo;

final class UsernameCopyPayord extends InfoCopierTemplate<UsernameInfo, PayordInfo>{
	
	public UsernameCopyPayord() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(PayordInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		
		return result;
	}
}
