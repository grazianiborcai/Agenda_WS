package br.com.mind5.payment.payOrderSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PayordarchSetterWebhookKey extends InfoSetterTemplate<PayordarchInfo> {
	
	@Override protected PayordarchInfo setAttrHook(PayordarchInfo recordInfo) {
		PayordarchInfo result = new PayordarchInfo();
		
		result.codOwner 	   = recordInfo.codOwner;
		result.username 	   = recordInfo.username;
		result.codLanguage 	   = recordInfo.codLanguage;
		result.hasWebhookEvent = true;

		return result;
	}
}
