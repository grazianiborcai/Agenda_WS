package br.com.mind5.paymentPartner.partnerMoip.orderMoip.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class OrdmoipSetterReceiverStore extends InfoSetterTemplate<OrdmoipInfo> {
	
	@Override protected OrdmoipInfo setAttrHook(OrdmoipInfo recordInfo) {
		recordInfo.itemReceiver = recordInfo.stoparData.idPayPartnerStore;

		return recordInfo;
	}
}
