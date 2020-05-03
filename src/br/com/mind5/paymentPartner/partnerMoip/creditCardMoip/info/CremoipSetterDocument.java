package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

import br.com.mind5.info.InfoSetterTemplate;


public final class CremoipSetterDocument extends InfoSetterTemplate<CremoipInfo> {
	
	@Override protected CremoipInfo setAttrHook(CremoipInfo recordInfo) {
		recordInfo.taxDocument = payloadFactory(
		        value("type"	, "CPF"),
		        value("number"	, recordInfo.cpfHolder)
		);


		return recordInfo;
	}
}
