package br.com.mind5.business.addressSearch.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

final class AddarchCopyCrecard extends InfoCopierTemplate<AddarchInfo, CrecardInfo> {
	
	public AddarchCopyCrecard() {
		super();
	}
	
	
	
	@Override protected AddarchInfo makeCopyHook(CrecardInfo source) {
		AddarchInfo result = new AddarchInfo();
		
		result.codOwner = source.codOwner;
		result.codAddress = source.codAddressHolder;
		result.codUser = source.codUser;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
