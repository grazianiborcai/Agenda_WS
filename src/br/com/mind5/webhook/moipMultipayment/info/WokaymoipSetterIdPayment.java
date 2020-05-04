package br.com.mind5.webhook.moipMultipayment.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class WokaymoipSetterIdPayment extends InfoSetterTemplate<WokaymoipInfo> {
	
	@Override protected WokaymoipInfo setAttrHook(WokaymoipInfo recordInfo) {
		WokaymoipInfo result = new WokaymoipInfo();				
		result.idPaymentPartner = recordInfo.id;

		return result;
	}
}
