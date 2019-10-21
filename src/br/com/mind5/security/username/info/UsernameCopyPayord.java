package br.com.mind5.security.username.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.payOrder.info.PayordInfo;

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
