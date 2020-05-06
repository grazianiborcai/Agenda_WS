package br.com.mind5.paymentPartner.partnerMoip.orderMoip.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class OrdmoipSetterOwnId extends InfoSetterTemplate<OrdmoipInfo> {
	
	@Override protected OrdmoipInfo setAttrHook(OrdmoipInfo recordInfo) {
		recordInfo.ownId = String.valueOf(recordInfo.payordemData.codOwner)
				         + "-"
				         + String.valueOf(recordInfo.payordemData.codPayOrder)
				         + "-"
				         + String.valueOf(recordInfo.payordemData.codPayOrderItem);
		
		return recordInfo;
	}
}
