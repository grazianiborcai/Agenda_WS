package br.com.mind5.discount.discountStore.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.discountStrategy.info.Disegy;

public final class DisoreSetterFirstTimeStrategy extends InfoSetterTemplate<DisoreInfo> {
	
	@Override protected DisoreInfo setAttrHook(DisoreInfo recordInfo) {
		recordInfo.codDiscountStrategy = Disegy.FIRST_TIME_PURCHASE.getCodDiscountStrategy();
		return recordInfo;
	}
}
