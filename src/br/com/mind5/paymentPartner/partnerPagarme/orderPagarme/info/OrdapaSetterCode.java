package br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info;

import br.com.mind5.info.InfoSetterTemplate;


public final class OrdapaSetterCode extends InfoSetterTemplate<OrdapaInfo> {
	
	@Override protected OrdapaInfo setAttrHook(OrdapaInfo recordInfo) {	
		recordInfo.code = recordInfo.codOwner    + "-" + 
	                      recordInfo.codPayOrder + "-" + 
				          recordInfo.codPayOrderItem;
		return recordInfo;
	}
}
