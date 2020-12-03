package br.com.mind5.discount.discountStoreSearch.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.discountStrategy.info.Disegy;

public final class DisorarchSetterStrategyFirstTime extends InfoSetterTemplate<DisorarchInfo> {
	
	@Override protected DisorarchInfo setAttrHook(DisorarchInfo recordInfo) {
		recordInfo.codDiscountStrategy = Disegy.FIRST_TIME_PURCHASE.getCodDiscountStrategy();
		return recordInfo;
	}
}
