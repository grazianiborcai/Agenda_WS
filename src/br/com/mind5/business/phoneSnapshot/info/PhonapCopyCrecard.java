package br.com.mind5.business.phoneSnapshot.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

final class PhonapCopyCrecard extends InfoCopierTemplate<PhonapInfo, CrecardInfo> {
	
	public PhonapCopyCrecard() {
		super();
	}
	
	
	
	@Override protected PhonapInfo makeCopyHook(CrecardInfo source) {
		PhonapInfo result = new PhonapInfo();
		
		result.codOwner    = source.codOwner;
		result.codPhone    = source.codPhoneHolder;		
		result.username    = source.username;
		result.codLanguage = source.codLanguage;
		result.codSnapshot = source.codPhoneSnapshotHolder;
		
		return result;
	}
}
