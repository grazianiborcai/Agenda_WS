package br.com.gda.payment.creditCardMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;


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
		        value("city"		, recordInfo.addressData.city),
		        value("district"	, recordInfo.addressData.district),
		        value("street"		, recordInfo.addressData.street),
		        value("streetNumber", recordInfo.addressData.streetNumber),
		        value("state"		, recordInfo.addressData.txtState),
		        value("country"		, recordInfo.addressData.codCountryAlpha3),
		        value("zipCode"		, recordInfo.addressData.postalCode)
		);


		return recordInfo;
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
