package br.com.mind5.security.username.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipInfo;

final class UsernameCopyAccemoip extends InfoCopierTemplate<UsernameInfo, AccemoipInfo> {
	
	public UsernameCopyAccemoip() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(AccemoipInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
