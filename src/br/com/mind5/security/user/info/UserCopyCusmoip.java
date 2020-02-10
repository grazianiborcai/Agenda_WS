package br.com.mind5.security.user.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.partnerMoip.customerMoip.info.CusmoipInfo;

final class UserCopyCusmoip extends InfoCopierTemplate<UserInfo, CusmoipInfo>{
	
	public UserCopyCusmoip() {
		super();
	}
	
	
	
	@Override protected UserInfo makeCopyHook(CusmoipInfo source) {
		UserInfo result = new UserInfo();
		
		result.codOwner = source.codOwner;	
		result.codUser = source.codUser;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
