package br.com.mind5.payment.payOrderItem.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PayordemSetterPayordKey extends InfoSetterTemplate<PayordemInfo> {
	
	@Override protected PayordemInfo setAttrHook(PayordemInfo recordInfo) {
		PayordemInfo result = new PayordemInfo();
		
		result.codOwner    = recordInfo.codOwner;
		result.username    = recordInfo.username;
		result.codPayOrder = recordInfo.codPayOrder;
		result.codLanguage = recordInfo.codLanguage;
		
		return result;
	}
}
