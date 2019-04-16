package br.com.gda.security.username.info;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.info.InfoCopierTemplate;

final class UsernameCopyCus extends InfoCopierTemplate<UsernameInfo, CusInfo>{
	
	public UsernameCopyCus() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(CusInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		
		return result;
	}
}
