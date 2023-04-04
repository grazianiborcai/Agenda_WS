package br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.moip.auth.Base64;

public final class SplitapaSetterAuthorization extends InfoSetterTemplate<SplitapaInfo> {
	
	@Override protected SplitapaInfo setAttrHook(SplitapaInfo recordInfo) {
		if (recordInfo.setuparData == null)
			return recordInfo;
		
		recordInfo.authorization = "Basic " + encodeSecretKey(recordInfo);

		return recordInfo;
	}	
	
	
	
	private String encodeSecretKey(SplitapaInfo recordInfo) {
		if (recordInfo.setuparData == null)
			return null;

		return Base64.encode((recordInfo.setuparData.secretKey + ":").getBytes());
	}
}
