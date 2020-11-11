package br.com.mind5.payment.storePartner.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class StoparSetterLChanged extends InfoSetterTemplate<StoparInfo> {
	
	@Override protected StoparInfo setAttrHook(StoparInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
