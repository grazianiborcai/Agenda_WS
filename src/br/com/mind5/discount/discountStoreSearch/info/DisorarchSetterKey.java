package br.com.mind5.discount.discountStoreSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class DisorarchSetterKey extends InfoSetterTemplate<DisorarchInfo> {
	
	@Override protected DisorarchInfo setAttrHook(DisorarchInfo recordInfo) {
		DisorarchInfo result = new DisorarchInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codStore = recordInfo.codStore;
		result.username = recordInfo.username;
		result.codLanguage = recordInfo.codLanguage;
		
		return result;
	}
}
