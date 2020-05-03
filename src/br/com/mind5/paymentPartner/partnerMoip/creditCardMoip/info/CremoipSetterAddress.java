package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

import br.com.mind5.info.InfoSetterTemplate;


public final class CremoipSetterAddress extends InfoSetterTemplate<CremoipInfo> {
	
	@Override protected CremoipInfo setAttrHook(CremoipInfo recordInfo) {
		recordInfo.billingAddress = payloadFactory(
		        value("city"		, recordInfo.addresnapData.city),
		        value("district"	, recordInfo.addresnapData.district),
		        value("street"		, recordInfo.addresnapData.street),
		        value("streetNumber", recordInfo.addresnapData.streetNumber),
		        value("state"		, recordInfo.addresnapData.txtState),
		        value("country"		, recordInfo.addresnapData.codCountryAlpha3),
		        value("zipCode"		, recordInfo.addresnapData.postalCode)
		);


		return recordInfo;
	}	
}
