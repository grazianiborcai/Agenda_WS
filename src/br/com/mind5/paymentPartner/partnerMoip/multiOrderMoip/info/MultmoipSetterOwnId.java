package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class MultmoipSetterOwnId extends InfoSetterTemplate<MultmoipInfo> {
	
	@Override protected MultmoipInfo setAttrHook(MultmoipInfo recordInfo) {
		recordInfo.ownId = recordInfo.codOwner + "-" + recordInfo.codPayOrder;
		
		return recordInfo;
	}
}
