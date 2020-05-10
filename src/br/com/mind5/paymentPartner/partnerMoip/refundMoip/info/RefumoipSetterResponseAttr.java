package br.com.mind5.paymentPartner.partnerMoip.refundMoip.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class RefumoipSetterResponseAttr extends InfoSetterTemplate<RefumoipInfo> {
	
	@Override protected RefumoipInfo setAttrHook(RefumoipInfo recordInfo) {
		recordInfo.idRefundPartner = (String) recordInfo.response.get("id");
		recordInfo.statusRefundPartner = (String) recordInfo.response.get("status");
		
		return recordInfo;
	}
}
