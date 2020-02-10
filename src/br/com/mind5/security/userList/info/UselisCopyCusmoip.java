package br.com.mind5.security.userList.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;

final class UselisCopyCusmoip extends InfoCopierTemplate<UselisInfo, CusmoipInfo>{
	
	public UselisCopyCusmoip() {
		super();
	}
	
	
	
	@Override protected UselisInfo makeCopyHook(CusmoipInfo source) {
		UselisInfo result = new UselisInfo();
		
		result.codOwner = source.codOwner;
		result.codUser = source.codUser;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
