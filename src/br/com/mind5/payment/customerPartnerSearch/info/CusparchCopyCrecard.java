package br.com.mind5.payment.customerPartnerSearch.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

final class CusparchCopyCrecard extends InfoCopierTemplate<CusparchInfo, CrecardInfo> {
	
	public CusparchCopyCrecard() {
		super();
	}
	
	
	
	@Override protected CusparchInfo makeCopyHook(CrecardInfo source) {
		CusparchInfo result = new CusparchInfo();
		
		result.codOwner = source.codOwner;
		result.codUser = source.codUser;	
		result.codPayPartner = source.codPayPartner;	
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
