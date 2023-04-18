package br.com.mind5.payment.payOrder.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PayordSetterHasWebhookEventOn extends InfoSetterTemplate<PayordInfo> {
	
	@Override protected PayordInfo setAttrHook(PayordInfo recordInfo) {
		recordInfo.hasWebhookEvent = true;
		return recordInfo;
	}
}
