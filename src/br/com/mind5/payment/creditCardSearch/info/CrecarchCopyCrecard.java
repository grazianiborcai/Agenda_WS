package br.com.mind5.payment.creditCardSearch.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

final class CrecarchCopyCrecard extends InfoCopierTemplate<CrecarchInfo, CrecardInfo>{
	
	public CrecarchCopyCrecard() {
		super();
	}
	
	
	
	@Override protected CrecarchInfo makeCopyHook(CrecardInfo source) {
		CrecarchInfo result = new CrecarchInfo();
		
		result.codOwner = source.codOwner;
		result.creditCardBrand = source.creditCardBrand;	
		result.creditCardLast4 = source.creditCardLast4;
		result.codPayCustomer = source.codPayCustomer;
		result.codLanguage = source.codLanguage;	
		result.username = source.username;	
		
		return result;
	}
}
