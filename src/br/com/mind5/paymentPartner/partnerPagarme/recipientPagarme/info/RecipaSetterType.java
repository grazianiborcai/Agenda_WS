package br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class RecipaSetterType extends InfoSetterTemplate<RecipaInfo> {
	
	@Override protected RecipaInfo setAttrHook(RecipaInfo recordInfo) {
		recordInfo.type = "company";
		return recordInfo;
	}	
}
