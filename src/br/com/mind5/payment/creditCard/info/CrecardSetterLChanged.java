package br.com.mind5.payment.creditCard.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class CrecardSetterLChanged extends InfoSetterTemplate<CrecardInfo> {
	
	@Override protected CrecardInfo setAttrHook(CrecardInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
