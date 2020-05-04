package br.com.mind5.payment.payOrder.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class PayordSetterLChanged extends InfoSetterTemplate<PayordInfo> {
	
	@Override protected PayordInfo setAttrHook(PayordInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
