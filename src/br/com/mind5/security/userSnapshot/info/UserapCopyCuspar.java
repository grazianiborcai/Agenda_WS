package br.com.mind5.security.userSnapshot.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class UserapCopyCuspar extends InfoCopierTemplate<UserapInfo, CusparInfo>{
	
	public UserapCopyCuspar() {
		super();
	}
	
	
	
	@Override protected UserapInfo makeCopyHook(CusparInfo source) {
		UserapInfo result = new UserapInfo();
		result.codOwner = source.codOwner;
		result.codUser = source.codUser;
		result.codSnapshot = source.codUserSnapshot;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		return result;
	}
}
