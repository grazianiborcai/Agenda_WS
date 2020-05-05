package br.com.mind5.webhook.moipRefund.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class WokefumoipSetterIdPayment extends InfoSetterTemplate<WokefumoipInfo> {
	
	@Override protected WokefumoipInfo setAttrHook(WokefumoipInfo recordInfo) {
		WokefumoipInfo result = new WokefumoipInfo();				
		result.idPaymentPartner = recordInfo.title;

		return result;
	}
}
