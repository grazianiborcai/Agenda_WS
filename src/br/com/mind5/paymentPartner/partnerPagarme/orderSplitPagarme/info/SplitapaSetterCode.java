package br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.info;

import br.com.mind5.info.InfoSetterTemplate;


public final class SplitapaSetterCode extends InfoSetterTemplate<SplitapaInfo> {
	
	@Override protected SplitapaInfo setAttrHook(SplitapaInfo recordInfo) {	
		recordInfo.code = recordInfo.codOwner + "-" + recordInfo.codPayOrder;
		return recordInfo;
	}
}
