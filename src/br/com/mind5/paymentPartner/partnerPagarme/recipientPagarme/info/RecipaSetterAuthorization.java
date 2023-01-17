package br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.moip.auth.Base64;

public final class RecipaSetterAuthorization extends InfoSetterTemplate<RecipaInfo> {
	
	@Override protected RecipaInfo setAttrHook(RecipaInfo recordInfo) {
		if (recordInfo.setuparData == null)
			return recordInfo;
		
		recordInfo.authorization = "Basic " + encodeSecretKey(recordInfo);

		return recordInfo;
	}	
	
	
	
	private String encodeSecretKey(RecipaInfo recordInfo) {
		if (recordInfo.setuparData == null)
			return null;

		return Base64.encode((recordInfo.setuparData.secretKey + ":").getBytes());
	}
}
