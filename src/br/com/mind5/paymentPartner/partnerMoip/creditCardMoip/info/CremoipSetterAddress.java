package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;


public final class CremoipSetterAddress implements InfoSetter<CremoipInfo> {
	
	public CremoipInfo setAttr(CremoipInfo recordInfo) {
		checkArgument(recordInfo);
		return setAddress(recordInfo);
	}
	
	
	
	private void checkArgument(CremoipInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private CremoipInfo setAddress(CremoipInfo recordInfo) {
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
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
