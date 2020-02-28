package br.com.mind5.security.username.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.refundOrder.info.RefuInfo;

final class UsernameCopyRefu extends InfoCopierTemplate<UsernameInfo, RefuInfo>{
	
	public UsernameCopyRefu() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(RefuInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
