package br.com.mind5.payment.payOrder.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class PayordSetterCreatedOn extends InfoSetterTemplate<PayordInfo> {
	
	@Override protected PayordInfo setAttrHook(PayordInfo recordInfo) {
		recordInfo.createdOn = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
