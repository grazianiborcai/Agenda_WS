package br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.moip.auth.Base64;

public final class OrdapaSetterAuthorization extends InfoSetterTemplate<OrdapaInfo> {
	
	@Override protected OrdapaInfo setAttrHook(OrdapaInfo recordInfo) {
		if (recordInfo.setuparData == null)
			return recordInfo;
		
		recordInfo.authorization = "Basic " + encodeSecretKey(recordInfo);

		return recordInfo;
	}	
	
	
	
	private String encodeSecretKey(OrdapaInfo recordInfo) {
		if (recordInfo.setuparData == null)
			return null;

		return Base64.encode((recordInfo.setuparData.secretKey + ":").getBytes());
	}
}
