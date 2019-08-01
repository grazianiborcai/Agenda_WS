package br.com.gda.security.username.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.refundOrder.info.RefuInfo;

final class UsernameCopyRefu extends InfoCopierTemplate<UsernameInfo, RefuInfo>{
	
	public UsernameCopyRefu() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(RefuInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		
		return result;
	}
}
