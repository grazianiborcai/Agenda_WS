package br.com.mind5.security.userSnapshot.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;

final class UserapCopyCusmoip extends InfoCopierTemplate<UserapInfo, CusmoipInfo>{
	
	public UserapCopyCusmoip() {
		super();
	}
	
	
	
	@Override protected UserapInfo makeCopyHook(CusmoipInfo source) {
		UserapInfo result = new UserapInfo();
		
		result.codOwner = source.codOwner;
		result.codSnapshot = source.codUserSnapshot;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
