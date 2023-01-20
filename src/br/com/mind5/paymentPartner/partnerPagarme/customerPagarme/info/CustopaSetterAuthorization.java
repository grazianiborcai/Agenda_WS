package br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.moip.auth.Base64;

public final class CustopaSetterAuthorization extends InfoSetterTemplate<CustopaInfo> {
	
	@Override protected CustopaInfo setAttrHook(CustopaInfo recordInfo) {
		if (recordInfo.setuparData == null)
			return recordInfo;
		
		recordInfo.authorization = "Basic " + encodeSecretKey(recordInfo);

		return recordInfo;
	}	
	
	
	
	private String encodeSecretKey(CustopaInfo recordInfo) {
		if (recordInfo.setuparData == null)
			return null;

		return Base64.encode((recordInfo.setuparData.secretKey + ":").getBytes());
	}
}
