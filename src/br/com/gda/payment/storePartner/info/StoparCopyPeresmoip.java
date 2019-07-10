package br.com.gda.payment.storePartner.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.permissionMoip.info.PeresmoipInfo;

final class StoparCopyPeresmoip extends InfoCopierTemplate<StoparInfo, PeresmoipInfo>{
	
	public StoparCopyPeresmoip() {
		super();
	}
	
	
	
	@Override protected StoparInfo makeCopyHook(PeresmoipInfo source) {
		StoparInfo result = new StoparInfo();
		
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;	
		result.codPayPartner = source.codPayPartner;
		result.idPayPartnerStore = source.code;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
