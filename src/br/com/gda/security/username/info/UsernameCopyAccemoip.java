package br.com.gda.security.username.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.accessMoip.info.AccemoipInfo;

final class UsernameCopyAccemoip extends InfoCopierTemplate<UsernameInfo, AccemoipInfo>{
	
	public UsernameCopyAccemoip() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(AccemoipInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		
		return result;
	}
}
