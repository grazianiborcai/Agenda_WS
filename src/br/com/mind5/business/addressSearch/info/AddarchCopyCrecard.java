package br.com.mind5.business.addressSearch.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

final class AddarchCopyCrecard extends InfoCopierTemplate<AddarchInfo, CrecardInfo> {
	
	public AddarchCopyCrecard() {
		super();
	}
	
	
	
	@Override protected AddarchInfo makeCopyHook(CrecardInfo source) {
		AddarchInfo result = new AddarchInfo();
		
		result.codUser     = source.codUser;
		result.codOwner    = source.codOwner;
		result.username    = source.username;
		result.codAddress  = source.codAddressHolder;		
		result.codLanguage = source.codLanguage;		
		
		return result;
	}
}
