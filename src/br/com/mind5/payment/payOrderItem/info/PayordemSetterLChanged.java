package br.com.mind5.payment.payOrderItem.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class PayordemSetterLChanged extends InfoSetterTemplate<PayordemInfo> {
	
	@Override protected PayordemInfo setAttrHook(PayordemInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
