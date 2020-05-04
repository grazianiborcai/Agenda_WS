package br.com.mind5.paymentPartner.partnerMoip.customerMoip.info;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

import br.com.mind5.info.InfoSetterTemplate;


public final class CusmoipSetterPhone extends InfoSetterTemplate<CusmoipInfo> {
	
	@Override protected CusmoipInfo setAttrHook(CusmoipInfo recordInfo) {
		recordInfo.phone = payloadFactory(
		        value("countryCode"	, String.valueOf(recordInfo.phonapData.codCountryPhone)),
		        value("areaCode"	, recordInfo.phonapData.codArea),
		        value("number"		, recordInfo.phonapData.number)
		);


		return recordInfo;
	}	
}
