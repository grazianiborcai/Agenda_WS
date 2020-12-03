package br.com.mind5.discount.discountStoreSearch.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class DisorarchSetterValidFrom extends InfoSetterTemplate<DisorarchInfo> {
	
	@Override protected DisorarchInfo setAttrHook(DisorarchInfo recordInfo) {
		recordInfo.validFrom = DefaultValue.localDateTimeNow();
		
		return recordInfo;
	}
}
