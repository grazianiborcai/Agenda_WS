package br.com.mind5.discount.discountStoreSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class DisorarchSetterActive extends InfoSetterTemplate<DisorarchInfo> {
	
	@Override protected DisorarchInfo setAttrHook(DisorarchInfo recordInfo) {
		recordInfo.isActive = true;
		return recordInfo;
	}
}
