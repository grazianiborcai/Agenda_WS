package br.com.mind5.payment.storePartner.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.partnerMoip.permissionMoip.info.PeresmoipInfo;

final class StoparCopyPeresmoip extends InfoCopierTemplate<StoparInfo, PeresmoipInfo>{
	
	public StoparCopyPeresmoip() {
		super();
	}
	
	
	
	@Override protected StoparInfo makeCopyHook(PeresmoipInfo source) {
		StoparInfo result = new StoparInfo();
		
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;	
		result.codPayPartner = source.codPayPartner;
		result.codePayPartnerStore = source.code;		
		result.accessToken = source.tokemoipData.accessToken;
		result.tokenExpiresIn = source.tokemoipData.tokenExpiresIn;
		result.refreshToken = source.tokemoipData.refreshToken;
		result.idPayPartnerStore = source.tokemoipData.idPayPartnerStore;
		result.scope = source.tokemoipData.scope;		
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
