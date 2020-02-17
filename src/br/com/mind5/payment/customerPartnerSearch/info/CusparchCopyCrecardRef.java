package br.com.mind5.payment.customerPartnerSearch.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

final class CusparchCopyCrecardRef extends InfoCopierTemplate<CusparchInfo, CrecardInfo>{
	
	public CusparchCopyCrecardRef() {
		super();
	}
	
	
	
	@Override protected CusparchInfo makeCopyHook(CrecardInfo source) {
		CusparchInfo result = new CusparchInfo();
		
		result.codOwner = source.codOwner;
		result.codPayCustomer = source.codPayCustomer;
		result.codUser = source.codUser;				
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
