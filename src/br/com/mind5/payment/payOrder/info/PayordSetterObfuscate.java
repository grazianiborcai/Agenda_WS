package br.com.mind5.payment.payOrder.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PayordSetterObfuscate extends InfoSetterTemplate<PayordInfo> {
	
	@Override protected PayordInfo setAttrHook(PayordInfo recordInfo) {
		PayordInfo result = new PayordInfo();
		
		result.codOwner 			= recordInfo.codOwner;
		result.codPayOrder 			= recordInfo.codPayOrder;
		result.statusOrderPartner 	= recordInfo.statusOrderPartner;
		result.codLanguage 			= recordInfo.codLanguage;
		result.username 			= recordInfo.username;
		
		return result;
	}
}
