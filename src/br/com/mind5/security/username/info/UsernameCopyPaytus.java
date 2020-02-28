package br.com.mind5.security.username.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;

final class UsernameCopyPaytus extends InfoCopierTemplate<UsernameInfo, PaytusInfo>{
	
	public UsernameCopyPaytus() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(PaytusInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
