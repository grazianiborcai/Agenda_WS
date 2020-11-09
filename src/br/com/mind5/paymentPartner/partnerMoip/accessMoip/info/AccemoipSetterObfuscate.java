package br.com.mind5.paymentPartner.partnerMoip.accessMoip.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class AccemoipSetterObfuscate extends InfoSetterTemplate<AccemoipInfo> {
	
	@Override protected AccemoipInfo setAttrHook(AccemoipInfo recordInfo) {
		AccemoipInfo obfuscated = new AccemoipInfo();
		
		obfuscated.codOwner = recordInfo.codOwner;
		obfuscated.codStore = recordInfo.codStore;	
		obfuscated.codPayPartner = recordInfo.codPayPartner;
		obfuscated.url = recordInfo.url;
		obfuscated.codLanguage = recordInfo.codLanguage;
		obfuscated.username = recordInfo.username;
		
		return obfuscated;
	}
}
