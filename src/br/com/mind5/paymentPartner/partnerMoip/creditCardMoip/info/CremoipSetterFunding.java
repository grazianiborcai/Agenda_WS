package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

import br.com.mind5.info.InfoSetterTemplate;


public final class CremoipSetterFunding extends InfoSetterTemplate<CremoipInfo> {
	
	@Override protected CremoipInfo setAttrHook(CremoipInfo recordInfo) {
		recordInfo.funding = payloadFactory(
		        value("method"	  , "CREDIT_CARD"),
		        value("creditCard", recordInfo.creditCard)
		);

		return recordInfo;
	}	
}
