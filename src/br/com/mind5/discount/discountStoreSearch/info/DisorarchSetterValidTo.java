package br.com.mind5.discount.discountStoreSearch.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class DisorarchSetterValidTo extends InfoSetterTemplate<DisorarchInfo> {
	
	@Override protected DisorarchInfo setAttrHook(DisorarchInfo recordInfo) {
		recordInfo.validTo = DefaultValue.localDateTimeNow();
		
		return recordInfo;
	}
}
