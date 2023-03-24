package br.com.mind5.payment.payOrder.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PayordSetterUpperCase extends InfoSetterTemplate<PayordInfo> {
	
	@Override protected PayordInfo setAttrHook(PayordInfo recordInfo) {
		if(recordInfo.statusOrderPartner != null)
			recordInfo.statusOrderPartner = recordInfo.statusOrderPartner.toUpperCase();
		
		if(recordInfo.statusPaymentPartner != null)
			recordInfo.statusPaymentPartner = recordInfo.statusPaymentPartner.toUpperCase();
		
		return recordInfo;
	}
}
