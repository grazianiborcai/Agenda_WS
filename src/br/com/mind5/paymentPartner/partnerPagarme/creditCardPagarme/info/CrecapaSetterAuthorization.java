package br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.moip.auth.Base64;

public final class CrecapaSetterAuthorization extends InfoSetterTemplate<CrecapaInfo> {
	
	@Override protected CrecapaInfo setAttrHook(CrecapaInfo recordInfo) {
		if (recordInfo.setuparData == null)
			return recordInfo;
		
		recordInfo.authorization = "Basic " + encodeSecretKey(recordInfo);

		return recordInfo;
	}	
	
	
	
	private String encodeSecretKey(CrecapaInfo recordInfo) {
		if (recordInfo.setuparData == null)
			return null;

		return Base64.encode((recordInfo.setuparData.secretKey + ":").getBytes());
	}
}
