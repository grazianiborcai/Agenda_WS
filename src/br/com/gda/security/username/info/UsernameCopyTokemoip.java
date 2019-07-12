package br.com.gda.security.username.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.tokenMoip.info.TokemoipInfo;

final class UsernameCopyTokemoip extends InfoCopierTemplate<UsernameInfo, TokemoipInfo>{
	
	public UsernameCopyTokemoip() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(TokemoipInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		
		return result;
	}
}
