package br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.info;

import br.com.mind5.info.InfoSetterTemplate;


public final class SplitapaSetterCustomerId extends InfoSetterTemplate<SplitapaInfo> {
	
	@Override protected SplitapaInfo setAttrHook(SplitapaInfo recordInfo) {
		if (recordInfo.payordData == null)
			return recordInfo;
		
		if (recordInfo.payordData.cusparData == null)
			return recordInfo;
		
		recordInfo.customerId = recordInfo.payordData.cusparData.customerId;
		return recordInfo;
	}
}
