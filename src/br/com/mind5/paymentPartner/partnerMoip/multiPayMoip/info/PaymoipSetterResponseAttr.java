package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PaymoipSetterResponseAttr extends InfoSetterTemplate<PaymoipInfo> {
	
	@Override protected PaymoipInfo setAttrHook(PaymoipInfo recordInfo) {	
		recordInfo.idPaymentPartner = (String) recordInfo.response.get("id");
		recordInfo.statusPaymentPartner = (String) recordInfo.response.get("status");
		
		return recordInfo;
	}
}
