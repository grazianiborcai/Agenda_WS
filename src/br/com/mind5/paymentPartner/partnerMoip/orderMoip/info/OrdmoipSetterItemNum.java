package br.com.mind5.paymentPartner.partnerMoip.orderMoip.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class OrdmoipSetterItemNum extends InfoSetterTemplate<OrdmoipInfo> {
	
	@Override protected OrdmoipInfo setAttrHook(OrdmoipInfo recordInfo) {
		recordInfo.itemNum = recordInfo.codPayOrderItem;

		return recordInfo;
	}
}
