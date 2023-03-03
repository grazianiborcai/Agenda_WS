package br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info;

import br.com.mind5.info.InfoSetterTemplate;


public final class OrdapaSetterCustomerId extends InfoSetterTemplate<OrdapaInfo> {
	
	@Override protected OrdapaInfo setAttrHook(OrdapaInfo recordInfo) {
		if (recordInfo.payordData == null)
			return recordInfo;
		
		if (recordInfo.payordData.cusparData == null)
			return recordInfo;
		
		recordInfo.customerId = recordInfo.payordData.cusparData.customerId;
		return recordInfo;
	}
}
