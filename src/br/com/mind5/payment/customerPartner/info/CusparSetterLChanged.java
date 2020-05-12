package br.com.mind5.payment.customerPartner.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class CusparSetterLChanged extends InfoSetterTemplate<CusparInfo> {
	
	@Override protected CusparInfo setAttrHook(CusparInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
