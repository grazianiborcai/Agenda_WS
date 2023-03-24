package br.com.mind5.business.phoneSearch.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

final class PhonarchCopyCrecard extends InfoCopierTemplate<PhonarchInfo, CrecardInfo> {
	
	public PhonarchCopyCrecard() {
		super();
	}
	
	
	
	@Override protected PhonarchInfo makeCopyHook(CrecardInfo source) {
		PhonarchInfo result = new PhonarchInfo();
		
		result.codUser     = source.codUser;
		result.codOwner    = source.codOwner;
		result.codPhone    = source.codPhoneHolder;		
		result.username    = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
