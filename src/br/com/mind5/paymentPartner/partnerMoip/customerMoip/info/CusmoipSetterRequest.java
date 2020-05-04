package br.com.mind5.paymentPartner.partnerMoip.customerMoip.info;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.mind5.info.InfoSetterTemplate;


public final class CusmoipSetterRequest extends InfoSetterTemplate<CusmoipInfo> {
	
	@Override protected CusmoipInfo setAttrHook(CusmoipInfo recordInfo) {
		recordInfo.requestBody = payloadFactory(
		        value("ownId"			, recordInfo.compoundId),
		        value("fullname"		, recordInfo.userapData.personData.name),
		        value("email"			, recordInfo.userapData.personData.email),
		        value("birthDate"		, formatDate(recordInfo.userapData.personData.birthDate)),
		        value("taxDocument"		, recordInfo.taxDocument),
		        value("phone"			, recordInfo.phone),
		        value("shippingAddress"	, recordInfo.shippingAddress)
		);

		return recordInfo;
	}	
	
	
	
	private String formatDate(LocalDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return date.format(formatter);
	}
}
