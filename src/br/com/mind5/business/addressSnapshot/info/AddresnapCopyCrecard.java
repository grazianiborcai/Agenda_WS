package br.com.mind5.business.addressSnapshot.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

final class AddresnapCopyCrecard extends InfoCopierTemplate<AddresnapInfo, CrecardInfo> {
	
	public AddresnapCopyCrecard() {
		super();
	}
	
	
	
	@Override protected AddresnapInfo makeCopyHook(CrecardInfo source) {
		AddresnapInfo result = new AddresnapInfo();
		
		result.codOwner     = source.codOwner;
		result.username     = source.username;
		result.codAddress   = source.codAddressHolder;
		result.codLanguage  = source.codLanguage;		
		result.codSnapshot  = source.codAddressSnapshotHolder;
		
		return result;
	}
}
