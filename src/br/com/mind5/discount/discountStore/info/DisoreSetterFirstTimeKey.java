package br.com.mind5.discount.discountStore.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class DisoreSetterFirstTimeKey extends InfoSetterTemplate<DisoreInfo> {
	
	@Override protected DisoreInfo setAttrHook(DisoreInfo recordInfo) {
		DisoreInfo result = new DisoreInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codStore = recordInfo.codStore;
		result.codDiscountStrategy = recordInfo.codDiscountStrategy;
		result.discountPercent = recordInfo.discountPercent;
		result.isActive = recordInfo.isActive;
		result.username = recordInfo.username;
		result.codLanguage = recordInfo.codLanguage;
		
		return recordInfo;
	}
}
