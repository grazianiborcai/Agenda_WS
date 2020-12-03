package br.com.mind5.discount.discountStore.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class DisoreSetterInactive extends InfoSetterTemplate<DisoreInfo> {
	
	@Override protected DisoreInfo setAttrHook(DisoreInfo recordInfo) {
		recordInfo.isActive = false;
		return recordInfo;
	}
}
