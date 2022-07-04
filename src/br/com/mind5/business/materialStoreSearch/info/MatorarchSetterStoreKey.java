package br.com.mind5.business.materialStoreSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class MatorarchSetterStoreKey extends InfoSetterTemplate<MatorarchInfo> {
	
	@Override protected MatorarchInfo setAttrHook(MatorarchInfo recordInfo) {	
		MatorarchInfo result = new MatorarchInfo();
		
		result.codOwner    = recordInfo.codOwner;
		result.codStore    = recordInfo.codStore;
		result.codLanguage = recordInfo.codLanguage;
		result.username    = recordInfo.username;
		
		return result;
	}
}
