package br.com.mind5.payment.payOrderItem.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PayordemSetterUpperCase extends InfoSetterTemplate<PayordemInfo> {
	
	@Override protected PayordemInfo setAttrHook(PayordemInfo recordInfo) {
		if(recordInfo.statusOrderPartner != null)
			recordInfo.statusOrderPartner = recordInfo.statusOrderPartner.toUpperCase();
		
		if(recordInfo.statusPaymentPartner != null)
			recordInfo.statusPaymentPartner = recordInfo.statusPaymentPartner.toUpperCase();
		
		if(recordInfo.statusRefundPartner != null)
			recordInfo.statusRefundPartner = recordInfo.statusRefundPartner.toUpperCase();
		
		return recordInfo;
	}
}
