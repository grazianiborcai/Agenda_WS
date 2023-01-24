package br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CrecapaSetterMetadata extends InfoSetterTemplate<CrecapaInfo> {
	
	@Override protected CrecapaInfo setAttrHook(CrecapaInfo recordInfo) {
		recordInfo.metadataId = String.valueOf(recordInfo.codOwner) 
				              + "-" 
				              + String.valueOf(recordInfo.codCreditCard);
		
		return recordInfo;
	}	
}
