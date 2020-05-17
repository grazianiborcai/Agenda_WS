package br.com.mind5.security.username.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info.TokemoipInfo;

final class UsernameCopyTokemoip extends InfoCopierTemplate<UsernameInfo, TokemoipInfo> {
	
	public UsernameCopyTokemoip() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(TokemoipInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
