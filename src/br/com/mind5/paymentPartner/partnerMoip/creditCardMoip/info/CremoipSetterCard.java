package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

import br.com.mind5.info.InfoSetterTemplate;


public final class CremoipSetterCard extends InfoSetterTemplate<CremoipInfo> {
	
	@Override protected CremoipInfo setAttrHook(CremoipInfo recordInfo) {
		recordInfo.creditCard = payloadFactory(
		        value("expirationMonth"	, recordInfo.expirationMonth),
		        value("expirationYear"	, recordInfo.expirationYear),
		        value("number"			, recordInfo.cardNumber),
		        value("cvc"				, recordInfo.cardCvc),		        
		        value("holder"			, recordInfo.holder)
		);

		return recordInfo;
	}
}
